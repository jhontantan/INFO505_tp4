package tp4;

import java.util.ArrayList;

public class Main {

	public final static int NOMBRE_VILLE = 5;
	public final static int NOMBRE_FOURMI = 10;


	public static void main(String[] args) {
		Carte carte = new Carte(NOMBRE_VILLE);
		Colonie colonie = new Colonie(NOMBRE_FOURMI);

	}

	public ArrayList<Ville> algoFourmi(Carte carte, Colonie colonie) {
		ArrayList<Ville> meilleurCycle;

		carte.repartirFourmis(colonie);

		while (!colonie.converge()) {
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini()) {
					fourmiCourante.villeSuivante(carte);
					//La fourmis change de ville (on actualise aussi son chemin)
				}
			}

			carte.evaporation();
			carte.deposerPheromone();
			meilleurCycle = colonie.getMeilleurCycle();
		}

		return meilleurCycle;
	}

}