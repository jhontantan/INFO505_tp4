package tp4;

import Fenetre.*;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class Main {
	
	public static void main(String[] args) {
		
		Algo algo = new Algo();
		//System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }		
				new Fenetre(algo);	
			}
		});
	}

}