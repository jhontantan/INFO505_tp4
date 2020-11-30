package tp4;

import java.util.ArrayList;

public class Carte {
	public final static int LARGEUR = 100;
	public final static int HAUTEUR = 100;

	private int nombreVille;
	private int a;
	private int b;
	private int q;
	private double c;
	
	private ArrayList<Ville> villes;
	
	private ArrayList<Arrete> arretes;

	public Carte(int nombreVille, int a, int b, int q, double c) {
		
		this.a = a;
		this.b = b;
		this.q = q;
		this.c = c;
		
		villes = new ArrayList<Ville>();
		
		arretes = new ArrayList<Arrete>();
		
		this.nombreVille = nombreVille;

		for (int i = 0; i < nombreVille; i++) {
			villes.add(new Ville());
		}
		
		initialiserArretes(); //Initialise toutes les liaisons entre les villes en evitant les doublons (arrete[v1 -> v2] <=> arrete[v2 -> v1])
	}

	
	private void initialiserArretes() {
		
		Ville villeCourante1;
		Ville villeCourante2;
		
		for (int i = 0; i < nombreVille; i++) {
			villeCourante1 = villes.get(i);
			for (int j=i; j<nombreVille; j++) {
				villeCourante2 = villes.get(j);
				if(!villeCourante1.equals(villeCourante2)) {
					//On verifie si le tableau arretes ne contient pas deja une arrete du m�me type (voir Arrete.equals())
					if(!(arretes.contains(new Arrete(villeCourante1, villeCourante2)))) {
						arretes.add(new Arrete(villeCourante1, villes.get(j)));
					}
				}
			}
		}
	}

	public ArrayList<Ville> getVilles(){
		return villes;
	}

	public Arrete getRandomArreteNotIn(Ville villeDepart, ArrayList<Arrete> arreteAlreadyUsed){
		
		ArrayList<Arrete> arreteNotUsed = new ArrayList<Arrete>(arretes);
		
		for (int i = 0; i < arretes.size(); i++) {//Supression des arretes deja utilisees
			if(arreteAlreadyUsed != null) {
				if(arreteAlreadyUsed.contains(arretes.get(i))) {
					arreteNotUsed.remove(arretes.get(i));
				}
			}
		}
			
		for (int i = 0; i < arretes.size(); i++) {//Supression des arrete qui ne contiennent pas la ville sur laquelle est actuelement la fourmi (elle ne peut pas se teleporter)
			if (!arretes.get(i).contient(villeDepart)) {
				arreteNotUsed.remove(arretes.get(i));
			}
		}
		
		
		return getArreteSuivanteParProba(arreteNotUsed);

	}
	
	private Arrete getArreteSuivanteParProba(ArrayList<Arrete> arreteNotUsed) {
		
		/*
		 * Dans un premier temps on calcul la probablite que la fourmi a d'emprunter chaque arrete
		 * La somme de toute ces probas est egale � 1
		 * On somme alors ces probabilites tel que P0' = P0 | P1' = P0 + P1 | P2' = P0 + P1 + P2 .... etc
		 * On genere ensuite un nombre random entre 1 et 0
		 * Et on selectionne l'arrete qui a la proba >= a ce nombre la plus proche
		 */
		
		double probas[] = new double[arreteNotUsed.size()];
		double probaPrecedente = 0;
		
		for (int i = 0; i < arreteNotUsed.size(); i++) { //Generation de toutes les probas
			probas[i] = probaPrecedente + getProba(arreteNotUsed.get(i), arreteNotUsed); //Et somme des probabilites
			probaPrecedente = probas[i];
		}
		
		double rand = Math.random(); //Generation du nombre aleatoire
		
		double lastProba = 0;
		int i = 0;
		
		while(i < probas.length) { //Selection de l'arrete (de son indice dans probas[])
			if(rand <= probas[i] && rand > lastProba) {
				break;
			}
			lastProba = probas[i];
			i++;
		}
		
		return arreteNotUsed.get(i);
	}
	
	
	 //Retourne la proba que la fourmi courante se deplace sur la ville suivante en utilisant l'arrete passee en parametre
	public double getProba(Arrete arrete, ArrayList<Arrete> arreteNotUsed) {
		
		double termeHaut = Math.pow(arrete.getQtePhe(), a) * Math.pow(1/arrete.getDistance(), b);
		
		double termeBas = 0;
		
		for (int i = 0; i < arreteNotUsed.size(); i++) {
			termeBas += Math.pow(arreteNotUsed.get(i).getQtePhe(), a) * Math.pow(1/arreteNotUsed.get(i).getDistance(), b);
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
		return villes.get((int) (Math.random()*nombreVille));
	}

	public void evaporation() {
		for (int i = 0; i < arretes.size(); i++) {
			arretes.get(i).evaporation(c);
		}
	}


	public void deposerPheromone(Colonie col) {
		for (int i = 0; i < col.getNombreFourmi(); i++) {
			
			Fourmi fourmiC = col.getFourmi(i);
			ArrayList<Arrete> chemin = fourmiC.getChemin();
			double distanceC = calculerDistanceChemin(chemin);
			
			for (int j = 0; j < chemin.size(); j++) {
				chemin.get(j).deposerPhe(q/distanceC);
			}
		}
	}

	public static double calculerDistanceChemin(ArrayList<Arrete> chemin) {	
		double distance = 0;
		
		for (int i = 0; i < chemin.size(); i++) {
			distance += chemin.get(i).getDistance();
		}
		return distance;
	}


}
