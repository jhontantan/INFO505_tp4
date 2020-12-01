package tp4;

import Fenetre.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Algo algo = new Algo();
		//System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
		new Fenetre(algo);		
	}

}