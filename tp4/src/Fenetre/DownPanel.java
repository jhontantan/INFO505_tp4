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
	private double distance;
	
	public DownPanel(Algo algo) {
		this.algo = algo;
		algo.addObserver(this);
		this.distance=Carte.calculerDistanceChemin(algo.algoFourmi());
		afficheText();
	}
	
	public void afficheText() {
		String res = "Le chemin optimale fait : " + Double.toString(distance) ;
		String duree = "		Temps Execution:"+ algo.getDuree()+"ms";
		Label label = new Label(res+duree);
		add(label);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		afficheText();
	}

}
