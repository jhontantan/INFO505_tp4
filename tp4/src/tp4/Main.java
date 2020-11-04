package tp4;

import java.util.ArrayList;

public class Main {
	
	public final static int Q = 1;
	public final static double C = 0.7;
	public final static int A = 1;
	public final static int B = 1;

	public final static int NOMBRE_VILLE = 5;
	public final static int NOMBRE_FOURMI = 10;


	public static void main(String[] args) {
		Carte carte = new Carte(NOMBRE_VILLE);
		Colonie colonie = new Colonie(NOMBRE_FOURMI);
		
		ArrayList<Arrete> meilleurCycle = algoFourmi(carte, colonie);
		
		System.out.println(carte.calculerDistanceChemin(meilleurCycle));
		
	}

	public static ArrayList<Arrete> algoFourmi(Carte carte, Colonie colonie) {
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();

		carte.repartirFourmis(colonie);
		
		int j = 0;

		while (/*!colonie.converge()*/ j < 10) {
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini()) {
					fourmiCourante.villeSuivante(carte);
					//La fourmis change de ville (on actualise aussi son chemin)
				}
			}

			carte.evaporation();
			carte.deposerPheromone(colonie); //TODO
			meilleurCycle = colonie.getMeilleurCycle();
			j++;
		}

		return meilleurCycle;
	}

}