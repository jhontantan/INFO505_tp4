package tp4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Fenetre.*;


@SuppressWarnings("serial")
public class Main extends JPanel{
	/*
	public final static int Q = 1;
	public final static double C = 0.7;
	public final static int A = 1;
	public final static int B = 1;

	public final static int NOMBRE_VILLE = 15;
	public final static int NOMBRE_FOURMI = 500;
	public final static int NOMBRE_CYCLE= 1;
	*/
	
	//private static ArrayList<Colonie> lsColonie;


	public static void main(String[] args) {
		/*
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            Fenetre();
	         }
	      });
	     */
		int a = 1;
		int b = 1;
		double c = 0.7;
		int q = 1;
		int nombreVille = 15;
		int nombreFourmi = 50;
		int nombreCycle = 1;
		
		Algo algo = new Algo(q, c, a, b, nombreVille, nombreFourmi, nombreCycle);
		System.out.println(Carte.calculerDistanceChemin(algo.algoFourmi()));
	}

/*
	private static void Fenetre()  {
    	JFrame frame = new JFrame("INFO505");

    //	UIManager.setLookAndFeel(new NimbusLookAndFeel());
       // setTitle("INFO504"); 
    	frame.setMinimumSize(new Dimension(800, 800));
        frame.setLocationRelativeTo(null);

        //Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - getHeight() / 2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

       // add(new RightPanel(), BorderLayout.EAST);
        frame.add(new CenterPanel(carte), BorderLayout.CENTER);
    
        frame.pack();
        frame.setVisible(true);
    }

	public static ArrayList<Colonie> getLsColonie() {
		return lsColonie;
	}
*/
}