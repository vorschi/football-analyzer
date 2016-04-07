package control;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Play;
import model.Player;
import model.Route;
import model.Position;

public class ImageDrawer extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image mshi;
    private Image mshi2;
    private Timer timer;
    private static int DELAY = 40;
    private boolean init = false;
    private ArrayList<Player> players;
    private Play play;
    private final int ARR_SIZE = 10;
    private Ellipse2D ellipse;
    private Point ellipsePoint;
    private boolean state = false;

   

    public ImageDrawer() {
        loadImage();
        ellipsePoint = new Point(490,390);
        ellipse = new Ellipse2D.Double(ellipsePoint.getX(), ellipsePoint.getY(), 20, 20);
        play = new Play();
        players = play.getPlayers();
        
        addMouseMotionListener(new MouseAdapter(){
        	  public void mousePressed(MouseEvent e) {
        		  int x = e.getX();
        		  int y = e.getY();
        		  ellipsePoint.setLocation(x-10,y-10);
        		  ellipse.setFrame(ellipsePoint.getX(), ellipsePoint.getY(), 20, 20);
        		  repaint();
        		  if (ellipse.contains(new Point(x,y))){
        			  System.out.println("juhuuuuuuuuuuu");
        		  }
        		  else 
        			  System.out.println("not so much");
        	  }
        	  
        	  public void mouseDragged(MouseEvent e){
        		  int x = e.getX();
        		  int y = e.getY();
        		  ellipsePoint.setLocation(x-10,y-10);
        		  ellipse.setFrame(ellipsePoint.getX(), ellipsePoint.getY(), 20, 20);
        		  repaint();
        	  }
        });
    }
    
    private void initTimer() {
    	init = true;
        timer = new Timer(DELAY, this);
        timer.setInitialDelay(500);
        timer.start();
    }

    private void loadImage() {
        mshi = new ImageIcon("pictures/sun.png").getImage();
        mshi2 = new ImageIcon("pictures/sun2.png").getImage();
    }
    
    private void doDrawing(Graphics g) {
      	Graphics2D g2d = (Graphics2D) g;
      	
      	g2d.drawLine(500, 500, (int) ellipsePoint.getX()+10, (int) ellipsePoint.getY()+10);
      	g2d.draw(ellipse);
      	g2d.drawLine((int) ellipsePoint.getX()+10, (int) ellipsePoint.getY()+10, 550, 380);
      	drawArrow(g2d, 550, 380, 550, 200);
        if (state){
      	for (int i = 0; i<players.size(); i++)
        	g2d.drawOval(players.get(i).getActX(), players.get(i).getActY(), 20,20);
        }
        else
        	for (int i = 0; i<players.size(); i++)
            	g2d.drawOval(players.get(i).getStartX(), players.get(i).getStartY(), 20,20);
        	
    }
    
    void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                      new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	public void stop(){
		timer.stop();
		state=false;
	}
	
	public void start(){
		if (!init)
			initTimer();
		else
			timer.restart();
		state=true;
	}
}
