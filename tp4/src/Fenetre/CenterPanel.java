package Fenetre;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp4.*;


public class CenterPanel extends JPanel  implements Observer{
	private static final long serialVersionUID = 1L;
	
	private Algo algo;
    public  static int CHEMIN_PADDING = 5;
    private static int pointWidth = 20;
    private static final Color GRAPH_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);
    
    private Color lineColor = new Color(0, 0, 255);
    private Color pointColor = new Color(255,0,0 );


	public CenterPanel(Algo algo) {
	     this.algo  = algo;
	     algo.addObserver(this);
        setBackground(Color.WHITE);
    }

	
 	
    //Afiche contenu
    @Override
    protected void paintComponent(Graphics g) {
		Colonie colonie = algo.getColonie();
		Carte carte = algo.getCarte();
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < carte.getVilles().size(); i++) {
            int x1 =  (carte.getVilles().get(i).getX());
            int y1 = (carte.getVilles().get(i).getY());

            graphPoints.add(new Point(x1, y1));
        }
        
		ArrayList<Arrete> meilleurCycle = new ArrayList<Arrete>();
		meilleurCycle = algo.algoFourmi();

        Stroke oldStroke = g2.getStroke();
   	 			
   	        g2.setColor(lineColor);
   	        g2.setStroke(GRAPH_STROKE);
   	        for (int i = 0; i < meilleurCycle.size(); i++) {
   	        	int coord[][] = meilleurCycle.get(i).getCoord();
   	        	g2.drawLine(coord[0][0]+pointWidth/2,
   	     	 		coord[0][1]+pointWidth/2,
   	     	 		coord[1][0]+pointWidth/2,
   	     	 		coord[1][1]+pointWidth/2);
   	        	System.out.println(" chemain "+coord[0][0]);
   	        }
  

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x, y, ovalW, ovalH);
        }	
    }
    
    @Override
    public void update(Observable o, Object arg) {
      this.repaint();
    }
}
