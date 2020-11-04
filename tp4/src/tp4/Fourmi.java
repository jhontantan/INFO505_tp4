package tp4;

import java.util.ArrayList;

public class Fourmi {
	public static int ID = 0;
	private int id;
	private ArrayList<Arrete> chemin;
	private Ville villeCourante;


	public Fourmi() {
		chemin = new ArrayList<Arrete>();
		this.id = ID++;
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
		return chemin.size() == Main.NOMBRE_VILLE;
	}


	public void villeSuivante(Carte carte) {
		//TODO attention, gerer la fin du cycle
		Ville villeRandom = carte.getRandomVilleNotIn(chemin);
		ArrayList<Arrete> arretes = carte.getArretes();
		chemin.add(arretes.get(arretes.indexOf(new Arrete(villeCourante, villeRandom))));
		villeCourante = villeRandom;
	}

}
