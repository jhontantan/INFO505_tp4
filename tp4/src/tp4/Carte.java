package tp4;

import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;

public class Carte {
	public final static int LARGEUR = 100;
	public final static int HAUTEUR = 100;


	private int nombreVille;
	private ArrayList<Ville> villes;
	private ArrayList<double[]> arretes;
	//[ville1, ville2, distance, qtePhe]

	public Carte(int nombreVille) {
		villes = new ArrayList<Ville>();
		arretes = new ArrayList<double[]>();
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
	
	public Ville getRandomVilleNotIn(ArrayList<Ville> villesAlreadyUsed){
		Random random = new Random();
		Ville villeCC = villes.get(random.nextInt(villes.size()));
		while (villesAlreadyUsed.contains(villeCC)) {
			villeCC = villes.get(random.nextInt(villes.size()));
		}
		return villeCC;
	}

	public ArrayList<double[]> getArretes(){
		return arretes;
	}

	public void repartirFourmis(Colonie colonie) {
		for (int i = 0; i < colonie.getNombreFourmi(); i++) {
			Fourmi fourmiCourante = colonie.getFourmi(i);
			fourmiCourante.ajouterVille(getVilleAleatoire());
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
			 arretes.get(i)[3] = (arretes.get(i)[3] * (1 - Main.C));
		}
		
	}

	public void deposerPheromone(Colonie col) {
		for (int i = 0; i < col.getNombreFourmi(); i++) {
			Fourmi fourmiC = col.getFourmi(i);
			ArrayList<Ville> chemin = fourmiC.getChemin();
			double distanceC = calculerDistanceChemin(chemin);
			//TODO
		}
	}
	
	private double calculerDistanceChemin(ArrayList<Ville> chemin) {
		//TODO
		
		return 0;
	}


}
