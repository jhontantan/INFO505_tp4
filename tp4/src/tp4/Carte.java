package tp4;

import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;

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
			//TODO
		}
	}

	public ArrayList<Ville> getVilles(){
		return villes;
	}

	public Ville getRandomVilleNotIn(ArrayList<Arrete> villesAlreadyUsed){
		Random random = new Random();
		Ville villeCC = villes.get(random.nextInt(villes.size()));
		if(villesAlreadyUsed != null) {
			while (villesAlreadyUsed.contains(new Arrete(villeCC))) {
				villeCC = villes.get(random.nextInt(villes.size()));
			}
		}
		return villeCC;
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
				chemin.get(i).deposerPhe(Main.Q/distanceC);
			}
		}
	}

	private double calculerDistanceChemin(ArrayList<Arrete> chemin) {
		double distance = 0;
		for (int i = 0; i < chemin.size(); i++) {
			distance += chemin.get(i).getDistance();
		}
		return distance;
	}


}
