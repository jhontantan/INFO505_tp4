package Fenetre;

import javax.swing.*;

import tp4.Algo;
import tp4.Carte;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MenuBar extends JToolBar implements ActionListener{
	
    private static final long serialVersionUID = 1L;

	JButton start = new JButton("Start");
	JTextField Nbfourmi = new JTextField(4);
	//JTextField NbCycle = new JTextField(4);
	JTextField NbVille = new JTextField(4);

    public MenuBar() {
        
    	add(new JLabel(" Quantité fourmis : "));
        add(Nbfourmi);
        addSeparator();

        add(new JLabel(" Quantité villes : "));
        add(NbVille);
        addSeparator();

      //  add(new JLabel("Quantité Cycles :"));
       // add(NbCycle);        
       // add(new JLabel(""));

        start.addActionListener(this);
        add(start);    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Start")) {
       /* 	
            System.exit(0);

 		   
 		   int a = 1;
 			int b = 1;
 			double c = 0.7;
 			int q = 1;
 			int nombreVille = 7;
 			int nombreFourmi = 1;
 			int nombreCycle = 1;
 	        Algo algo = new Algo(q, c, a, b, nombreVille, nombreFourmi, nombreCycle);
 	        
 	        //Fenetre tmpFenetre = new Fenetre(algo);

 	    	System.out.println("Yes Button pressed!");
 			System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
 			
*/

 			//System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
 			 
 			 
 	    }
 	   }
    

}
