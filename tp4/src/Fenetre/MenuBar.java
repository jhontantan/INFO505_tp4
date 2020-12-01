package Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuBar extends JToolBar {
	
    private static final long serialVersionUID = 1L;

	JButton start = new JButton("Start");
	JTextField Nbfourmi = new JTextField(4);
	//JTextField NbCycle = new JTextField(4);
	JTextField NbVille = new JTextField(4);


	
	
	

    public MenuBar() {
       //setLayout(new GridLayout(20, 1,2,2));
        


        add(new JLabel(" Quantité fourmis : "));
        add(Nbfourmi);
        addSeparator();

        add(new JLabel(" Quantité villes : "));
        add(NbVille);
        addSeparator();


      //  add(new JLabel("Quantité Cycles :"));
       // add(NbCycle);        
       // add(new JLabel(""));

        //start.addActionListener(this);

        add(start);


        




        
        
        
    }
    
  //  public void actionPerformed(ActionEvent e) {
//    	NombreCycle = getT
//}


}
