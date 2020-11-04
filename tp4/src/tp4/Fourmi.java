package tp4;

import java.util.ArrayList;

public class Fourmi {
	private ArrayList<Arrete> chemin;
	private Ville villeCourante;


	public Fourmi() {
		chemin = new ArrayList<Arrete>();
	}


	public boolean auDepart(Ville v) {
		villeCourante = v;
		chemin = new ArrayList<Arrete>();
		return false;
	}
	
	public ArrayList<Arrete> getChemin(){
		return chemin;
	}
	

	public boolean cheminFini() {
		return chemin.size() == Main.NOMBRE_VILLE-1;
	}


	public void villeSuivante(Carte carte) {
		Ville villeRandom = carte.getRandomVilleNotIn(chemin);
		ArrayList<Arrete> arretes = carte.getArretes();
		chemin.add(arretes.get(arretes.indexOf(new Arrete(villeCourante, villeRandom))));
		villeCourante = villeRandom;
	}

}
