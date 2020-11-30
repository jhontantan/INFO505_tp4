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
	
	public final static int Q = 1;
	public final static double C = 0.7;
	public final static int A = 1;
	public final static int B = 1;

	public final static int NOMBRE_VILLE = 15;
	public final static int NOMBRE_FOURMI = 500;
	public final static int NOMBRE_CYCLE= 1;
	
	private static Carte carte;
	private static Colonie colonie;
	private static ArrayList<Colonie> lsColonie;



	public static void main(String[] args) {
		 carte = new Carte(NOMBRE_VILLE); //Generation de la carte (placement aleatoire des villes)
		
		for (int i = 0; i < NOMBRE_CYCLE; i++) {
			colonie = new Colonie(NOMBRE_FOURMI); //Initialisation des fourmis
			ArrayList<Arrete> meilleurCycle = algoFourmi(carte, colonie);
			System.out.println(carte.calculerDistanceChemin(meilleurCycle));
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	            Fenetre();
	         }
	      });

		
	}

	public static ArrayList<Arrete> algoFourmi(Carte carte, Colonie colonie) {
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();
		lsColonie= new ArrayList<Colonie>();


		carte.repartirFourmis(colonie); //Repartition aleatoire des fourmis sur la carte
		//ATTENTION reinitialiser le chemin des fourmis
		int j = 0;

		while (/*!colonie.converge()*/ j < 100) {
			for (int i = 0; i < colonie.getNombreFourmi(); i++) {
				Fourmi fourmiCourante = colonie.getFourmi(i);
				while (!fourmiCourante.cheminFini()) { //Si le cycle fourmi n'est pas termine
					fourmiCourante.villeSuivante(carte); //Alors la fourmi se deplace sur la ville suivante
				}
			}
			
			carte.evaporation();
			carte.deposerPheromone(colonie);
			lsColonie.add(colonie);
			meilleurCycle = garderMeilleurCycle(carte, colonie.getMeilleurCycle(), meilleurCycle);
			carte.repartirFourmis(colonie);
			j++;
		}

		return meilleurCycle;
	}
	
	private static ArrayList<Arrete> garderMeilleurCycle(Carte carte, ArrayList<Arrete> cycle1, ArrayList<Arrete> cycle2){
		double dist1 = carte.calculerDistanceChemin(cycle1);
		double dist2 = carte.calculerDistanceChemin(cycle2);
		if(dist1 == 0) {
			return cycle2;
		} else if (dist2 == 0) {
			return cycle1;
		} else if(dist1 > dist2) {
			return cycle2;
		} else {
			return cycle1;
		}

	}
	
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
	
	

}