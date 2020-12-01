package Fenetre;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;


import tp4.Algo;

public class Fenetre extends JFrame{
	
	private static final long serialVersionUID = 1L;


	public Fenetre(Algo algo)  {

    //	UIManager.setLookAndFeel(new NimbusLookAndFeel());
        setTitle("INFO504"); 
    	setMinimumSize(new Dimension(800, 800));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

       // add(new RightPanel(), BorderLayout.EAST);
      //  add(new RightPanel(editor, this), BorderLayout.NORTH);
        add(new JScrollPane(new CenterPanel(algo)), BorderLayout.CENTER);
        add(new DownPanel(algo),BorderLayout.SOUTH );
    
        pack();
        setVisible(true);
    }



}
