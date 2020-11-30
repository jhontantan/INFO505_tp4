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

import tp4.Arrete;
import tp4.Carte;
import tp4.Colonie;
import tp4.Fourmi;
import tp4.Main;
import tp4.Ville;

@SuppressWarnings("serial")
public class CenterPanel extends JPanel{
	private int padding = 20;
    private int labelPadding = 12;
	private Carte carte;
    private static int pointWidth = 10;
    private static final Color GRAPH_COLOR = Color.blue;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);

    private Color pointColor = new Color(255,0,0 );
	private Colonie colonie;
	private ArrayList<Colonie> lsColonie;



   // Jeu jeu = new Jeu();

	public CenterPanel(Carte carte) {
		this.lsColonie = Main.getLsColonie();
		this.carte=carte;
        setBackground(Color.WHITE);
        
    }

	
 	
    //Afiche contenu
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < carte.getVilles().size(); i++) {
            int x1 =  (carte.getVilles().get(i).getX());
            int y1 = (carte.getVilles().get(i).getY());

            graphPoints.add(new Point(x1, y1));
        }
        

        
        
        
   //::  List<Point> graphPointsArrete = new ArrayList<>();
     //   for (int i = 0; i < 1; i++) {
    	//	System.out.println(lsColonie.get(1).getFourmi(499));
    	//	System.out.println(lsColonie.get(1).getFourmi(499).getChemin().get(1).);

        //	Fourmi fourmiCourante = lsColonie.get(1);
        	//Arrete arreteCourante = fourmiCourante.getChemin().get(0);
        	//Ville villeCourante1 = arreteCourante.getVille1();
        	//System.out.println(villeCourante1.getX());

		//	for (int j = 0; j < arreteCourante.size(); j++) {
				//Ville villeCourante = arreteCourante;

			//}
        	
			

        	//arreteCourante.
			//System.out.println(" fourmi"+fourmiCourante.);

			//System.out.println(" chemain "+fourmiCourante.getChemin().size());

        	
          //  int x1 =  (lsColonie.ge);
            //int y1 = (carte.getVilles().get(i).getY());

            //graphPoints.add(new Point(x1, y1));
      //  }
         
        Stroke oldStroke = g2.getStroke();
       /*
        g2.setColor(GRAPH_COLOR);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
           int x1 = graphPoints.get(i).x;
           int y1 = graphPoints.get(i).y;
           int x2 = graphPoints.get(i + 1).x;
           int y2 = graphPoints.get(i + 1).y;
           g2.drawLine(x1*5, y1*5, x2, y2);         
        }
*/
        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x*5, y*5, ovalW, ovalH);
        }	
    }
   
    /*
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double xScale = ((double) getWidth() - (3 * padding) - labelPadding) / (scores.size() - 1);
        double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

        List<Ville> graphPoints = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((getMaxScore() - ville.get(i)) * yScale + padding);
            graphPoints.add(new Point(x1, y1));
        }

        g2.setColor(Color.WHITE);
	    //fill the rect
        g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - 
        		labelPadding, getHeight() - 2 * padding - labelPadding);
        g2.setColor(Color.BLUE);

        

        }

   
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
        g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() -
        		padding, getHeight() - padding - labelPadding);

        Stroke oldStroke = g2.getStroke();
        g2.setColor(lineColor);
        g2.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
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
    } */

}
