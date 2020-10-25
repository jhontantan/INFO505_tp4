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


	public void ajouterVille(Ville v) {
		chemin.add(v);
	}

	 public int cheminEffectue(int n) {
		return n = chemin.size();
	}

}
