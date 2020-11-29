package view;

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

import tp4.Carte;
import tp4.Main;
import tp4.Ville;


public class CenterPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private int padding = 20;
    private int labelPadding = 12;
    private ArrayList<Ville> tmpVilles;
	private Carte carte;
    private static int pointWidth = 10;
    private Color pointColor = new Color(255,0,0 );



   // Jeu jeu = new Jeu();

	public CenterPanel(Carte carte) {
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
        
        Stroke oldStroke = g2.getStroke();

        g2.setStroke(oldStroke);
        g2.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            g2.fillOval(x*10, y*10, ovalW, ovalH);
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
