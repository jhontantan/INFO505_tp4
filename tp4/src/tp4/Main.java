package tp4;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Fenetre.*;


@SuppressWarnings("serial")
public class Main extends JPanel{
	
	//private static ArrayList<Colonie> lsColonie;


	public static void main(String[] args) {

		int a = 1;
		int b = 1;
		double c = 0.7;
		int q = 1;
		int nombreVille = 15;
		int nombreFourmi = 50;
		int nombreCycle = 1;
		Carte carte;
		Colonie colonie;
		
		Algo algo = new Algo(q, c, a, b, nombreVille, nombreFourmi, nombreCycle);
		
		new Fenetre(algo);
		System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
		
		
	}

}