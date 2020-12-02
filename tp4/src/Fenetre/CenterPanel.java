package Fenetre;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.*;
import javax.swing.Timer;


import javax.swing.JPanel;

import tp4.*;


public class CenterPanel extends JPanel {
	private static final long serialVersionUID = 1L;

    private List<Shape> shapes;
    public  static int CHEMIN_PADDING = 5;
    private static int pointWidth =20;
    private static final Stroke GRAPH_STROKE = new BasicStroke(3f);

    private Color lineColor = new Color(0, 0, 255);
    private Color pointColor = new Color(255,0,0 );

    private ArrayList<Arrete> chemin;
    private Carte carte;
    Line2D line;
	private int y = -2;



	public CenterPanel(ArrayList<Arrete> chemin, Carte carte) {
		this.chemin = chemin;
		this.carte = carte;

		shapes = new ArrayList<>(chemin.size());
		
		Timer timer = new Timer(200, new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
                 if(y<chemin.size()&&y>=0) {

         			int coord[][] = chemin.get(y).getCoord();
         			line = new Line2D.Double(coord[0][0]+pointWidth/2, coord[0][1]+pointWidth/2, coord[1][0]+pointWidth/2, coord[1][1]+pointWidth/2);

         			shapes.add(line);
          			
                 }
                 y++;
                 repaint();
         }

   	    });
		timer.setInitialDelay(200);
		timer.start();
    }



    //Afiche contenu
	@Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
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
 			
   	    g2.setStroke(GRAPH_STROKE);
   	    g2.setColor(lineColor);
   	  
   	    //draw lines
   	    for (Shape line1 : shapes) {

   	    	g2.draw(line1);
   	    }

   	    g2.dispose();
  
    }

} 
