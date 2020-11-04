package tp4;

import java.util.ArrayList;

public class Fourmi {
	public static int ID = 0;
	private int id;
	private ArrayList<Ville> chemin;


	public Fourmi() {
		chemin =  new ArrayList<Ville>();
		this.id = ID++;
	}


	public boolean ajouterVille(Ville v) {
		if(chemin.contains(v)) {
			chemin.add(v);
			return true;
		}
		return false;
	}
	
	public ArrayList<Ville> getChemin(){
		return chemin;
	}
	
	/*
	 public int cheminEffectue(int n) {
		return n = chemin.size();
	}
	*/
	

	public boolean cheminFini() {
		return chemin.size() == Main.NOMBRE_VILLE;
	}


	public void villeSuivante(Carte carte) {
		chemin.add(carte.getRandomVilleNotIn(chemin));
	}

}
