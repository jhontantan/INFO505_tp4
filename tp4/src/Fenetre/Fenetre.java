package Fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import tp4.Algo;
import tp4.Arrete;

public class Fenetre extends JFrame{
	private static final long serialVersionUID = 1L;


	public Fenetre(Algo algo)  {

        setTitle("INFO505"); 
    	setMinimumSize(new Dimension(800, 800));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        
        ArrayList<Arrete> chemin = algo.algoFourmi();
        
        add(new MenuBar(), BorderLayout.NORTH);
        add(new DownPanel(chemin, algo.getDuree()),BorderLayout.SOUTH );
        add(new JScrollPane(new CenterPanel(chemin, algo.getCarte())), BorderLayout.CENTER);
    
        pack();
        setVisible(true);
    }



}
