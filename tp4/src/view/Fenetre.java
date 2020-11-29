package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


import javax.swing.*;

import tp4.Carte;
import tp4.Main;

import java.awt.*;



public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	private Carte carte;



    public Fenetre(Carte carte) {
        setTitle("INFO504"); 
        setMinimumSize(new Dimension(1000, 1000));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

       // add(new RightPanel(), BorderLayout.EAST);
        add(new CenterPanel(carte), BorderLayout.CENTER);
    
        pack();
        setVisible(true);
    }
}


   