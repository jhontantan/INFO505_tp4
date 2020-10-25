package tp4;

import java.util.ArrayList;

import java.util.ArrayList;

public class Carte {
	public final static int LARGEUR = 100;
	public final static int HAUTEUR = 100;


	private int nombreVille;
	private ArrayList<Ville> villes;
	private ArrayList<int[]> arretes;
	//[ville1, ville2, qtePhe]

	public Carte(int nombreVille) {
		villes = new ArrayList<Ville>();
		arretes = new ArrayList<int[]>();
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

	public ArrayList<int[]> getArretes(){
		return arretes;
	}

	public void repartirFourmis(Colonie colonie) {
		for (int i = 0; i < colonie.getNombreFourmi(); i++) {
			Fourmi fourmiCourante = colonie.getFourmi(i);
			fourmiCourante.ajouterVille(getVilleAleatoire());
		}

	}

	public Ville getVilleAleatoire() {
		return villes.get((int) Math.random()*nombreVille);
	}
	/*

	public void evaporation() {
		for (int i = 0; i < arretes.size(); i++) {

		}
	}
	*/


}
