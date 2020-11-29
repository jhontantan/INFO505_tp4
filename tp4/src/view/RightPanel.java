package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RightPanel extends JPanel {
	JButton start = new JButton("Start");
	JTextField Nbfourmi = new JTextField(4);
	JTextField NbCycle = new JTextField(4);
	JTextField NbVille = new JTextField(4);


	
	
	

    public RightPanel() {
        setBackground(Color.DARK_GRAY);
        setLayout(new GridLayout(20, 1,2,2));
        add(new JLabel(""));
        add(new JLabel(""));

        add(new JLabel(""));

        add(new JLabel(""));
        add(new JLabel(""));


        add(new JLabel("Quantité fourmis :"));
        add(Nbfourmi);
        add(new JLabel(""));

        add(new JLabel("Quantité villes :"));
        add(NbVille);
        add(new JLabel(""));


        add(new JLabel("Quantité Cycles :"));

        add(NbCycle);        
        add(new JLabel(""));
        //start.addActionListener(this);

        add(start);

        add(new JLabel(""));

        add(new JLabel(""));        
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));

        




        
        
        
    }
    
  //  public void actionPerformed(ActionEvent e) {
//    	NombreCycle = getT
//}


}
