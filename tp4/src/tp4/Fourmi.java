package tp4;

import java.util.ArrayList;

public class Fourmi {
	private ArrayList<Arrete> chemin; //Le chemin parcouru pas la fourmi
	private Ville villeCourante; //La ville actuelle ou se situe la fourmi


	public Fourmi() {
		chemin = new ArrayList<Arrete>();
	}


	public void auDepart(Ville v) {
		villeCourante = v;
	}
	
	public ArrayList<Arrete> getChemin(){
		return chemin;
	}
	

	public boolean cheminFini() { //Test si le cycle fourmi est termine
		return chemin.size() == Main.NOMBRE_VILLE-1;
	}


	public void villeSuivante(Carte carte) { //La fourmi passe a la ville suivante
		Arrete randomArrete = carte.getRandomArreteNotIn(villeCourante, chemin);
		chemin.add(randomArrete); 
		
		if(randomArrete.getVille1().equals(villeCourante)) { //On actualise la ville courante
			villeCourante = randomArrete.getVille2();
		} else {
			villeCourante = randomArrete.getVille1();
		}
	}

}
