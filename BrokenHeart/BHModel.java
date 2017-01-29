import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

// image stuff
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class BHModel {
	
	BrokenHeart app;
	int size=17;
	
	Piece[] piece;
	int nPieces;

	boolean dragging;
	int selected;
	
	public BHModel(BrokenHeart brokenHeart) {
		this.app = brokenHeart;
		nPieces = 8;
		piece = new Piece[8];
		for (int i=0 ; i<8; i++) piece[i] = new Piece(i);
		this.restart();
	}

	public void restart() {
		dragging = false;
		selected = 0;
		piece[0].setLoc(0,1);
		piece[1].setLoc(6,6);
		piece[2].setLoc(0,12);
		piece[3].setLoc(11,11);
		piece[4].setLoc(6,0);
		piece[5].setLoc(1,6);
		piece[6].setLoc(12,5);
		piece[7].setLoc(6,11);
	}
	
	public void selectPiece ( int xLoc , int yLoc ) {
		dragging = false;
		for (int i=0 ; i<nPieces ; i++) if (piece[i].overlaps(xLoc,yLoc)) {
			dragging = true;
			selected = i;
		}
		
	}
	
	public boolean moveNorth () {
		boolean ret = false;
		if (dragging) ret = piece[selected].moveNorth(piece);
		return ret;
	}

	public boolean moveSouth () {
		boolean ret = false;
		if (dragging) ret = piece[selected].moveSouth(piece);
		return ret;
	}

	public boolean moveWest () {
		boolean ret = false;
		if (dragging) ret = piece[selected].moveWest(piece);
		return ret;
	}

	public boolean moveEast () {
		boolean ret = false;
		if (dragging) ret = piece[selected].moveEast(piece);
		return ret;
	}

	public void deselectPiece () {
		dragging = false;
	}

}


