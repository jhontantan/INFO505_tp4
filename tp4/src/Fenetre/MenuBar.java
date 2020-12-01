package Fenetre;

import javax.swing.*;

import tp4.*;

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
        
    	add(new JLabel(" Quantite fourmis : "));
        add(Nbfourmi);
        addSeparator();

        add(new JLabel(" Quantite villes : "));
        add(NbVille);
        addSeparator();
        /*
        add(new JLabel("Quantité Cycles :"));
        add(NbCycle);        
        add(new JLabel(""));
        addSeparator();
        */

        start.addActionListener(this);
        add(start);    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
		Algo algo;
        String action = e.getActionCommand();
        if (action.equals("Start")) {
        	
        	JFrame frame = (JFrame)this.getRootPane().getParent(); 
     	
        	if(NbVille.getText().isEmpty() || Nbfourmi.getText().isEmpty() /*|| NbCycle.getText().isEmpty()*/) {
           	 	frame.dispose();
           	 	 algo = new Algo();  
        	}
        	else {
        	  	int JfieldVille = Integer.parseInt(NbVille.getText());
        	  	int JfieldFourmis = Integer.parseInt(Nbfourmi.getText());
        	  	//int JfieldCycles = Integer.parseInt(NbCycle.getText());

        	  	frame.dispose();
        	
        	  	int a = 1;
        	  	int b = 1;
        	  	double c = 0.7;
        	  	int q = 1;
        	  	int nombreVille = JfieldVille;
        	  	int nombreFourmi = JfieldFourmis;
        	  	//int nombreCycle = JfieldCycles;
        	  	algo = new Algo(q, c, a, b, nombreVille, nombreFourmi, 1);
        	}
        	try {
				new Fenetre(algo);
        	}catch (UnsupportedLookAndFeelException e1) {
 	    	  	// TODO Auto-generated catch block
				e1.printStackTrace();
        	}				 
        }
    }
}
