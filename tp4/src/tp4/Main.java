package tp4;

import Fenetre.*;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
	
	public static void main(String[] args) {
		
		Algo algo = new Algo();
		//System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }		
				new Fenetre(algo);	
			}
		});
	}

}