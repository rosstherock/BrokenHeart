import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

// image stuff
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class Piece {

	int x,y,width,height,m,xMax,yMax,id;

	public Piece(int id) {
		m=8;
		switch(id) {
			default:
			case 0:
				x=0;
				y=1;
				width=6;
				height=5;
				break;
			case 1:
				x=0;
				y=1;
				width=6;
				height=5;
				break;
			case 2:
				x=0;
				y=1;
				width=6;
				height=5;
				break;
			case 3:
				x=0;
				y=1;
				width=6;
				height=5;
				break;
			case 4:
				x=0;
				y=1;
				width=5;
				height=6;
				break;
			case 5:
				x=0;
				y=1;
				width=5;
				height=6;
				break;
			case 6:
				x=0;
				y=1;
				width=5;
				height=6;
				break;
			case 7:
				x=0;
				y=1;
				width=5;
				height=6;
				break;
		}
		xMax = 17-width;
		yMax = 17-height;
	}

	
	public void setSize ( int wI , int hI ) {
		this.width = wI;
		this.height = hI;
	}

	public void setLoc ( int xI , int yI ) {
		this.x = xI;
		this.y = yI;
	}

	public boolean overlaps ( int a , int b ) {
		return (this.x<=a && this.y<=b && this.x+this.width>a && this.y+this.height>b);
	}

	private int neighbour ( Piece p ) {
		int ret = 0;
		if ( this.x<p.x+p.width && this.x>p.x-this.width) {
			if ( this.y==p.y-this.height ) ret = 3;
			else if ( this.y==p.y+p.height ) ret = 1;
		} else if ( this.y<p.y+p.height && this.y>p.y-this.height) {
			if ( this.x==p.x-this.width ) ret = 4;
			else if ( this.x==p.x+p.width ) ret = 2;
		} 
		return ret;
	}
	
	public boolean moveNorth(Piece[] allPieces) {
		boolean ret = true;
		if (this.y==0) ret = false;
		for ( int i=0 ; i<m ; i++ ) if ( this.neighbour(allPieces[i])==1 ) ret = false;
		if (ret) this.y--;
		return ret;
	}

	public boolean moveWest(Piece[] allPieces) {
		boolean ret = true;
		if (this.x==0) ret = false;
		for ( int i=0 ; i<m ; i++ ) if ( this.neighbour(allPieces[i])==2 ) ret = false;
		if (ret) this.x--;
		return ret;
	}

	public boolean moveSouth(Piece[] allPieces) {
		boolean ret = true;
		if (this.y>=yMax) ret = false;
		for ( int i=0 ; i<m ; i++ ) if ( this.neighbour(allPieces[i])==3 ) ret = false;
		if (ret) this.y++;
		return ret;
	}

	public boolean moveEast(Piece[] allPieces) {
		boolean ret = true;
		if (this.x>=xMax) ret = false;
		for ( int i=0 ; i<m ; i++ ) if ( this.neighbour(allPieces[i])==4 ) ret = false;
		if (ret) this.x++;
		return ret;
	}

}





