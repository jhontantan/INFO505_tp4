package tp4;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import Fenetre.*;


@SuppressWarnings("serial")
public class Main extends JPanel{
	
	public static long duree;
	public static void main(String[] args) throws Exception {
		
		int a = 1;
		int b = 1;
		double c = 0.7;
		int q = 1;
		int nombreVille = 15;
		int nombreFourmi = 3;
		int nombreCycle = 1;
		
		long start = System.currentTimeMillis();
		Algo algo = new Algo(q, c, a, b, nombreVille, nombreFourmi, nombreCycle);
		//System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
		duree = System.currentTimeMillis() - start;

		new Fenetre(algo);
		
		
	}

}