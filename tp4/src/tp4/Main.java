package tp4;

import java.util.ArrayList;

public class Main {
	
	public final static int Q = 1;
	public final static double C = 0.7;
	public final static int A = 1;
	public final static int B = 1;

	public final static int NOMBRE_VILLE = 15;
	public final static int NOMBRE_FOURMI = 500;


	public static void main(String[] args) {
		Carte carte = new Carte(NOMBRE_VILLE); //Generation de la carte (placement aleatoire des villes)
		
		for (int i = 0; i < 10; i++) {
			Colonie colonie = new Colonie(NOMBRE_FOURMI); //Initialisation des fourmis
			ArrayList<Arrete> meilleurCycle = algoFourmi(carte, colonie);
			System.out.println(carte.calculerDistanceChemin(meilleurCycle));
		}

		
	}

	public static ArrayList<Arrete> algoFourmi(Carte carte, Colonie colonie) {
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();

		carte.repartirFourmis(colonie); //Repartition aleatoire des fourmis sur la carte
		//ATTENTION reinitialiser le chemin des fourmis
		int j = 0;

		while (/*!colonie.converge()*/ j < 100) {
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini()) { //Si le cycle fourmi n'est pas termine
					fourmiCourante.villeSuivante(carte); //Alors la fourmi se deplace sur la ville suivante
				}
			}
			
			carte.evaporation();
			carte.deposerPheromone(colonie);
			meilleurCycle = garderMeilleurCycle(carte, colonie.getMeilleurCycle(), meilleurCycle);
			
			carte.repartirFourmis(colonie);
			j++;
		}

		return meilleurCycle;
	}
	
	private static ArrayList<Arrete> garderMeilleurCycle(Carte carte, ArrayList<Arrete> cycle1, ArrayList<Arrete> cycle2){
		double dist1 = carte.calculerDistanceChemin(cycle1);
		double dist2 = carte.calculerDistanceChemin(cycle2);
		if(dist1 == 0) {
			return cycle2;
		} else if (dist2 == 0) {
			return cycle1;
		} else if(dist1 > dist2) {
			return cycle2;
		} else {
			return cycle1;
		}

	}

}