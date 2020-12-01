package Fenetre;


import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


import tp4.Algo;
import tp4.Carte;
import tp4.Main;

public class DownPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private Algo algo;
	private Carte carte;
	
	public DownPanel(Algo algo) {
		this.algo = algo;
		carte = algo.getCarte();
		algo.addObserver(this);
		afficheText();
	}
	
	public void afficheText() {
		//		String res = "Le chemin optimale fait : " + Integer.toString(Main.distanceParcours);
		String duree = "		Temps:"+Main.duree;
		String res = "Le chemin optimale fait : " + Double.toString(carte.calculerDistanceChemin(algo.algoFourmi())) ;
		Label label = new Label(res+duree);
		//label.setFont(new Font("TimesRoman", Font.BOLD, 25));
		add(label);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		afficheText();
	}

}
