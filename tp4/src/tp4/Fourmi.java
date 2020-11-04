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


	public boolean ajouterVille(Ville v, ArrayList<Arrete> arretes) {
		if(!chemin.contains(v)) {
			chemin.add(arretes.get(arretes.indexOf(new Arrete(villeCourante, v))));
			villeCourante = v;
			return true;
		}
		return false;
	}
	
	public ArrayList<Arrete> getChemin(){
		return chemin;
	}
	

	public boolean cheminFini() {
		return chemin.size() == Main.NOMBRE_VILLE;
	}


	public void villeSuivante(Carte carte) {
		chemin.add(carte.getRandomVilleNotIn(chemin));
	}

}
