package tp4;

import java.util.ArrayList;
import java.util.Random;

public class Carte {
	public final static int LARGEUR = 100;
	public final static int HAUTEUR = 100;


	private int nombreVille;
	private ArrayList<Ville> villes;
	private ArrayList<Arrete> arretes;

	public Carte(int nombreVille) {
		villes = new ArrayList<Ville>();
		arretes = new ArrayList<Arrete>();
		this.nombreVille = nombreVille;

		for (int i = 0; i < nombreVille; i++) {
			villes.add(new Ville());
		}
		initialiserArretes();
	}

	
	private void initialiserArretes() {
		Ville villeCourante;
		for(int i = 0; i < nombreVille; i++) {
			villeCourante = villes.get(i);
			for(int j=i; j<nombreVille; j++) {
				Ville deuxVille = villes.get(j);
				if(!villeCourante.equals(deuxVille)) {
					if  (!(arretes.contains(new Arrete(villeCourante,deuxVille)))) {
						arretes.add(new Arrete(villeCourante, villes.get(j)));
					}
				}
			}
		}
	}

	public ArrayList<Ville> getVilles(){
		return villes;
	}

	public Ville getRandomVilleNotIn(Ville villeDepart, ArrayList<Arrete> arreteAlreadyUsed){
		
		ArrayList<Arrete> arreteNotUsed = arretes;
		

			arreteNotUsed = arretes;
			
			for (int i = 0; i < arretes.size(); i++) {
				if(arreteAlreadyUsed != null) {
					if(arreteAlreadyUsed.contains(arretes.get(i))) {
						arreteNotUsed.remove(arretes.get(i));
					}
				}
			}
				
			for (int i = 0; i < arretes.size(); i++) {
				if (!arretes.get(i).contient(villeDepart)) {
					arreteNotUsed.remove(arretes.get(i));
				}
			}
			
			double probas[] = new double[arreteNotUsed.size()];
			
			
			double probaPrecedente = 0;
			for (int i = 0; i < probas.length; i++) {
				probas[i] = probaPrecedente + getProba(arreteNotUsed.get(i), arreteNotUsed);
				probaPrecedente = probas[i];
			}
			
			double rand = Math.random();
			
			double lastProba = 0;
			int i = 0;
			
			while(i < probas.length) {
				if(rand <= probas[i] && rand > lastProba) {
					break;
				}
				lastProba = probas[i];
				i++;
			}
			
			if(arreteNotUsed.get(i).getVille1().equals(villeDepart)) {
				return arreteNotUsed.get(i).getVille2();
			} else {
				return arreteNotUsed.get(i).getVille1();
			}
	}
	
	public double getProba(Arrete arrete, ArrayList<Arrete> arreteNotUsed) {
		
		double termeHaut = Math.pow(arrete.getQtePhe(), Main.A) * Math.pow(1/arrete.getDistance(), Main.B);
		
		double termeBas = 0;
		for (int i = 0; i < arreteNotUsed.size(); i++) {
			termeBas += Math.pow(arreteNotUsed.get(i).getQtePhe(), Main.A) * Math.pow(1/arreteNotUsed.get(i).getDistance(), Main.B);
		}

		return termeHaut/termeBas;
		

	}
	
	

	public ArrayList<Arrete> getArretes(){
		return arretes;
	}

	public void repartirFourmis(Colonie colonie) {
		for (int i = 0; i < colonie.getNombreFourmi(); i++) {
			Fourmi fourmiCourante = colonie.getFourmi(i);
			fourmiCourante.auDepart(getVilleAleatoire());
		}

	}

	public double getDistance(Ville depart, Ville arrive){
		int x = depart.getX() - arrive.getX();
		int y = depart.getY() - arrive.getY();
		return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
	}

	public Ville getVilleAleatoire() {
		return villes.get((int) Math.random()*nombreVille);
	}

	public void evaporation() {
		for (int i = 0; i < arretes.size(); i++) {
			arretes.get(i).evaporation();
		}
	}


	public void deposerPheromone(Colonie col) {
		for (int i = 0; i < col.getNombreFourmi(); i++) {
			Fourmi fourmiC = col.getFourmi(i);
			ArrayList<Arrete> chemin = fourmiC.getChemin();
			double distanceC = calculerDistanceChemin(chemin);
			for (int j = 0; j < chemin.size(); j++) {
				//Besoin d'aller rechercher dans l'att arretes de Carte ? (pointeurs?)
				chemin.get(j).deposerPhe(Main.Q/distanceC);
			}
		}
	}

	public double calculerDistanceChemin(ArrayList<Arrete> chemin) {
		double distance = 0;
		for (int i = 0; i < chemin.size(); i++) {
			distance += chemin.get(i).getDistance();
		}
		return distance;
	}


}
