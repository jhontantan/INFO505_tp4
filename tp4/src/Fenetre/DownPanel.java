package Fenetre;


import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JPanel;


import tp4.Arrete;
import tp4.Carte;

public class DownPanel extends JPanel  {
	private static final long serialVersionUID = 1L;

	private ArrayList<Arrete> chemin;
	private long duree;
	private double distance;
	
	public DownPanel(ArrayList<Arrete> chemin, long duree) {
		this.chemin = chemin;
		this.duree = duree;
		this.distance=Carte.calculerDistanceChemin(chemin);
		afficheText();
	}
	
	public void afficheText() {
		String res = "Le chemin optimale fait : " + (int) distance + "   " ;
		String dureeTxt = "		Temps Execution: "+ duree +" ms";
		Label label = new Label(res+dureeTxt);
		add(label);
	}
}
