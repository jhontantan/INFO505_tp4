package Fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import tp4.Algo;

public class Fenetre extends JFrame{
	private static final long serialVersionUID = 1L;


	public Fenetre(Algo algo) throws UnsupportedLookAndFeelException  {

    	UIManager.setLookAndFeel(new NimbusLookAndFeel());
        setTitle("INFO505"); 
    	setMinimumSize(new Dimension(800, 800));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(new MenuBar(), BorderLayout.NORTH);
        add(new DownPanel(algo),BorderLayout.SOUTH );
        add(new JScrollPane(new CenterPanel(algo)), BorderLayout.CENTER);
    
        pack();
        setVisible(true);
    }



}
