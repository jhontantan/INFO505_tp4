package tp4;

import java.util.ArrayList;

public class Main {
	
	public final static int Q = 1;
	public final static double C = 0.7;
	public final static int A = 1;
	public final static int B = 1;

	public final static int NOMBRE_VILLE = 5;
	public final static int NOMBRE_FOURMI = 50;


	public static void main(String[] args) {
		Carte carte = new Carte(NOMBRE_VILLE); //Generation de la carte (placement aleatoire des villes)
		Colonie colonie = new Colonie(NOMBRE_FOURMI); //Initialisation des fourmis
		
		for (int i = 0; i < 20; i++) {
			ArrayList<Arrete> meilleurCycle = algoFourmi(carte, colonie);
			System.out.println(carte.calculerDistanceChemin(meilleurCycle));
		}

		
	}

	public static ArrayList<Arrete> algoFourmi(Carte carte, Colonie colonie) {
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();

		carte.repartirFourmis(colonie); //Repartition aleatoire des fourmis sur la carte
		
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
			meilleurCycle = colonie.getMeilleurCycle();
			j++;
		}

		return meilleurCycle;
	}

}