package Fenetre;

import javax.swing.*;


import tp4.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class MenuBar extends JToolBar implements ActionListener{
	
    private static final long serialVersionUID = 1L;
    
    Algo algo;
	JButton start = new JButton("Start");
	JTextField Nbfourmi = new JTextField(4);
	JTextField NbCycle = new JTextField(4);
	JTextField NbVille = new JTextField(4);

    public MenuBar(Algo algo) {
    	
        
    	add(new JLabel(" Quantité fourmis : "));
        add(Nbfourmi);
        addSeparator();

        add(new JLabel(" Quantité villes : "));
        add(NbVille);
        addSeparator();

        add(new JLabel("Quantité Cycles :"));
        add(NbCycle);        
        add(new JLabel(""));
        addSeparator();

      //  start.addActionListener(this);
        add(start);    
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    /*
    @Override
  
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Start")) {
        	
        	JFrame frame = (JFrame)this.getRootPane().getParent(); 
        	
           int JfieldVille = Integer.parseInt(NbVille.getText());
           int JfieldFourmis = Integer.parseInt(Nbfourmi.getText());
           int JfieldCycles = Integer.parseInt(NbCycle.getText());
           
           
           


        
 	        
 	       		 
 	    }
 	    
 	   }
 	   */

	
	
	
    

}
