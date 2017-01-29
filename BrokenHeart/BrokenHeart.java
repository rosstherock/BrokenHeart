import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

// image stuff
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class BrokenHeart extends JApplet implements MouseListener,MouseMotionListener {
	
	static final long serialVersionUID = 42L;
	
	static JFrame f;
	BHModel model;
	BHView view;
	int xoff,yoff;
	int cX,cY,dX,dY;
	
	public static void main(String args[]) {
		f = new JFrame("Can you fix the broken heart");
		BrokenHeart app = new BrokenHeart();
		app.init();
		f.add("Center",app);
		f.setSize(650,650);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public BrokenHeart() {}
	public void init() {
		setBackground(Color.darkGray);
		model = new BHModel(this);
		view = new BHView(this);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	

	public void paint(Graphics g) {
		Dimension d = this.getSize();
		xoff = (d.width-510)/2;
		yoff = (d.height-510)/2;
		update(g);
	}
	public void update(Graphics g) {
		Image im = this.createImage(510,510);
		Graphics imG = im.getGraphics();
		view.paint(imG);
		Image backBuffer = this.createImage(514,514);
		Graphics backG = backBuffer.getGraphics();
		backG.setColor(Color.lightGray);
		backG.fillRect(0,0,514,514);
		backG.drawImage(im,2,2,null);
		g.drawImage(backBuffer,xoff,yoff,null);
		
	}

	public void mouseExited (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) {}
	public void mouseClicked (MouseEvent e) {}
	public void mouseMoved (MouseEvent e) {}
	public void mousePressed (MouseEvent e) {
		cX = e.getX();
		int x = cX-xoff;
		cY = e.getY();
		int y = cY-yoff;
		model.selectPiece( (int)(x/30) , (int)(y/30) );
		repaint();
	}
	public void mouseDragged (MouseEvent e) {
		dX = e.getX()-cX;
		dY = e.getY()-cY;
		if (dX>dY && dX>-dY && dX>30) {
			if (model.moveEast()) {
				cX += 30;
				repaint();
			}
		} else if (dX<dY && dX<-dY && dX<-30) {
			if (model.moveWest()) {
				cX -= 30;
				repaint();
			}
		} else if (dY>dX && dY>-dX && dY>30) {
			if (model.moveSouth()) {
				cY += 30;
				repaint();
			}
		} else if (dY<dX && dY<-dX && dY<-30) {
			if (model.moveNorth()) {
				cY -= 30;
				repaint();
			}
		}
	}
	public void mouseReleased (MouseEvent e) {
		model.deselectPiece();
	}
	
	public void restart() {
		model.restart();
		repaint();
	}
}












