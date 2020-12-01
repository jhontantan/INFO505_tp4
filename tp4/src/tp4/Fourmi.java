package tp4;

import java.util.ArrayList;

public class Fourmi {
	private ArrayList<Arrete> chemin; //Le chemin parcouru pas la fourmi
	private Ville villeCourante; //La ville actuelle ou se situe la fourmi
	private Ville villePrec; //La ville actuelle ou se situe la fourmi


	public Fourmi() {
		chemin = new ArrayList<Arrete>();
	}


	public void auDepart(Ville v) {
		villeCourante = v;
		villePrec = null;
		chemin = new ArrayList<Arrete>();
	}
	
	public ArrayList<Arrete> getChemin(){
		return chemin;
	}
	

	public boolean cheminFini(int nombreVille) { //Test si le cycle fourmi est termine
		return chemin.size() == nombreVille-1;
	}


	public void villeSuivante(Carte carte) { //La fourmi passe a la ville suivante
		Arrete randomArrete = carte.getRandomArreteNotIn(villeCourante, villePrec, cheminToVilles(chemin));
		
		chemin.add(randomArrete); 
		villePrec = villeCourante;

		if(randomArrete.getVille1().equals(villeCourante)) { //On actualise la ville courante
			villeCourante = randomArrete.getVille2();
		} else {
			villeCourante = randomArrete.getVille1();
		}
	}
	
	private ArrayList<Ville> cheminToVilles(ArrayList<Arrete> chemin){
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Arrete arr;
		for (int i = 0; i < chemin.size(); i++) {
			arr = chemin.get(i);
			if(!arr.contient(villeCourante)) {
				if(!villes.contains(arr.getVille1())) {
					villes.add(arr.getVille1());
				}
				if(!villes.contains(arr.getVille2())) {
					villes.add(arr.getVille2());
				}
			}

		}
		return villes;
	}

}
