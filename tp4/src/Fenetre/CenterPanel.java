package Fenetre;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.*;

import javax.swing.JPanel;

import tp4.*;


public class CenterPanel extends JPanel  implements Observer{
	private static final long serialVersionUID = 1L;

    public  static int CHEMIN_PADDING = 5;
    private static int pointWidth =20;
    private static final Color GRAPH_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);

    private Color lineColor = new Color(0, 0, 255);
    private Color pointColor = new Color(255,0,0 );

    private ArrayList<Arrete> chemin;
    private Carte carte;


	public CenterPanel(ArrayList<Arrete> chemin, Carte carte) {
		this.chemin = chemin;
		this.carte = carte;
	     setBackground(Color.WHITE);
    }



    //Afiche contenu
    public void paint(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Stroke oldStroke = g2.getStroke();

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < carte.getVilles().size(); i++) {
            int x = (carte.getVilles().get(i).getX());
            int y = (carte.getVilles().get(i).getY()) ;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }
 			
   	    g2.setColor(lineColor);
   	    g2.setStroke(GRAPH_STROKE);
   	    for (int i = 0; i < chemin.size(); i++) {
   	        int coord[][] = chemin.get(i).getCoord();
   	        g2.drawLine(
   	        		coord[0][0]+pointWidth/2,
   	     	 		coord[0][1]+pointWidth/2,
   	     	 		coord[1][0]+pointWidth/2,
   	     	 		coord[1][1]+pointWidth/2);
   	        }
    }

    @Override
    public void update(Observable o, Object arg) {
      this.repaint();
    }
}
