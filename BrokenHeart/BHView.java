import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

// image stuff
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class BHView {
	
	BrokenHeart app;
	BHModel m;

	public BHView(BrokenHeart a) {
		this.app = a;
		this.m = a.model;
	}
	
	public void paint(Graphics g) {

		g.setColor(Color.lightGray);
		g.fillRect(0,0,510,510);
		
		/*** Piece 0 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[0].x+2 , 30*m.piece[0].y+2 , 30*m.piece[0].width-4 , 30*m.piece[0].height-4 );
		g.setColor(Color.black);
		g.fillArc( 30*m.piece[0].x+60 , 30*m.piece[0].y+30 , 236 , 236 , 90 , 90);
		g.setColor(Color.pink);
		g.fillArc( 30*m.piece[0].x+120 , 30*m.piece[0].y+90 , 116 , 116 , 90 , 90);
		g.setColor(Color.black);
		g.drawRect ( 30*m.piece[0].x+2 , 30*m.piece[0].y+2 , 30*m.piece[0].width-4 , 30*m.piece[0].height-4 );

		/*** Piece 1 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[1].x+2 , 30*m.piece[1].y+2 , 30*m.piece[1].width-4 , 30*m.piece[1].height-4 );
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[1].x+60 , 30*m.piece[1].y+2 , 60 , 118 );
		g.fillRect ( 30*m.piece[1].x+60 , 30*m.piece[1].y+60 , 118 , 60 );
		g.drawRect ( 30*m.piece[1].x+2 , 30*m.piece[1].y+2 , 30*m.piece[1].width-4 , 30*m.piece[1].height-4 );

		/*** Piece 2 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[2].x+2 , 30*m.piece[2].y+2 , 30*m.piece[2].width-4 , 30*m.piece[2].height-4 );
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[2].x+60 , 30*m.piece[2].y+2 , 60 , 58 );
		g.fillRect ( 30*m.piece[2].x+60 , 30*m.piece[2].y+30 , 118 , 60 );
		g.drawRect ( 30*m.piece[2].x+2 , 30*m.piece[2].y+2 , 30*m.piece[2].width-4 , 30*m.piece[2].height-4 );

		/*** Piece 3 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[3].x+2 , 30*m.piece[3].y+2 , 30*m.piece[3].width-4 , 30*m.piece[3].height-4 );
		g.setColor(Color.black);
		g.fillArc( 30*m.piece[3].x-86 , 30*m.piece[3].y-116 , 236 , 236 , 270 , 90);
		g.setColor(Color.pink);
		g.fillArc( 30*m.piece[3].x-26 , 30*m.piece[3].y-56 , 116 , 116 , 270 , 90);
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[3].x+2 , 30*m.piece[3].y+60 , 31 , 60 );
		g.drawRect ( 30*m.piece[3].x+2 , 30*m.piece[3].y+2 , 30*m.piece[3].width-4 , 30*m.piece[3].height-4 );

		/*** Piece 4 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[4].x+2 , 30*m.piece[4].y+2 , 30*m.piece[4].width-4 , 30*m.piece[4].height-4 );
		g.setColor(Color.black);
		g.fillArc( 30*m.piece[4].x-116 , 30*m.piece[4].y+60 , 236 , 236 , 0 , 90);
		g.setColor(Color.pink);
		g.fillArc( 30*m.piece[4].x-56 , 30*m.piece[4].y+120 , 116 , 116 , 0 , 90);
		g.setColor(Color.black);
		g.drawRect ( 30*m.piece[4].x+2 , 30*m.piece[4].y+2 , 30*m.piece[4].width-4 , 30*m.piece[4].height-4 );

		/*** Piece 5 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[5].x+2 , 30*m.piece[5].y+2 , 30*m.piece[5].width-4 , 30*m.piece[5].height-4 );
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[5].x+30 , 30*m.piece[5].y+2 , 60 , 176 );
		g.drawRect ( 30*m.piece[5].x+2 , 30*m.piece[5].y+2 , 30*m.piece[5].width-4 , 30*m.piece[5].height-4 );

		/*** Piece 6 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[6].x+2 , 30*m.piece[6].y+2 , 30*m.piece[6].width-4 , 30*m.piece[6].height-4 );
		g.setColor(Color.black);
		g.fillArc( 30*m.piece[6].x-116 , 30*m.piece[6].y+30 , 236 , 236 , 0 , 90);
		g.setColor(Color.pink);
		g.fillArc( 30*m.piece[6].x-56 , 30*m.piece[6].y+90 , 116 , 116 , 0 , 90);
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[6].x+60 , 30*m.piece[6].y+147 , 60 , 31 );
		g.drawRect ( 30*m.piece[6].x+2 , 30*m.piece[6].y+2 , 30*m.piece[6].width-4 , 30*m.piece[6].height-4 );

		/*** Piece 7 ***/

		g.setColor(Color.pink);
		g.fillRect ( 30*m.piece[7].x+2 , 30*m.piece[7].y+2 , 30*m.piece[7].width-4 , 30*m.piece[7].height-4 );
		g.setColor(Color.black);
		g.fillRect ( 30*m.piece[7].x+2 , 30*m.piece[7].y+60 , 146 , 60 );
		g.drawRect ( 30*m.piece[7].x+2 , 30*m.piece[7].y+2 , 30*m.piece[7].width-4 , 30*m.piece[7].height-4 );

	}
	

}


