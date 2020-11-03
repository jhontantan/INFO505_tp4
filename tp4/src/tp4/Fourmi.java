package tp4;

import java.util.ArrayList;

public class Fourmi {
	public static int ID = 0;
	private int id;
	//private int positionVille;
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
	
	/*
	 public int cheminEffectue(int n) {
		return n = chemin.size();
	}
	*/


	public boolean cheminFini() {
		return chemin.size() == Main.NOMBRE_VILLE;
	}

}
