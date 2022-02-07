package gridApp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.Piece;
import gridApp.model.Puzzle;

public class PuzzlePanel extends JPanel {
	
	Model aModel;
	
	public static final int pieceSize = 120;
	public static final int offset = 2;

	
	public PuzzlePanel(Model m) {
		this.aModel = m;
	}
	
	public Rectangle compR (Piece p) {
		int col = p.getCol();
		int row = p.getRow();
		Rectangle rec = new Rectangle(col*pieceSize + offset,row*pieceSize + offset,pieceSize-2*offset,pieceSize-2*offset);
		return rec;
	}
	
	public Coordinate pointCoordinate(Point p) {
		return new Coordinate(p.x/pieceSize,p.y/pieceSize);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(aModel == null) {return;}

		Piece selectP = aModel.getSelectedPiece();
		Puzzle aPuzzle = aModel.getaPuzzle();
		
		for (Piece p : aPuzzle) {
			if (p.equals(selectP)) {
				g.setColor(Color.yellow);
			} else {
				g.setColor(Color.gray);
			}
			String s = "" + p.getNumVal();
			Rectangle r = compR(p);
			g.fillRect(r.x, r.y, r.width, r.height);
			Font font = new Font("Arial", Font.BOLD, 70);
			g.setFont(font);
			g.setColor(Color.black);
			if (!(aModel.getTargetPiece() == null) && !aModel.isGameOver()) {//checkGameOver
				if (p.contains(new Coordinate(aModel.getTargetPiece().getCol(), aModel.getTargetPiece().getRow()))) {
					g.setColor(Color.red);
				}
			}
			if (p.getNumVal() > 99) {
				g.drawString(s, r.x + pieceSize / 2 - 30 * offset, r.y + pieceSize / 2 + 10 * offset);
			} else if (p.getNumVal() > 9) {
				g.drawString(s, r.x + pieceSize / 2 - 20 * offset, r.y + pieceSize / 2 + 10 * offset);
			} else {
				g.drawString(s, r.x + pieceSize / 2 - 10 * offset, r.y + pieceSize / 2 + 10 * offset);
			}
			g.setColor(Color.black);
			if (p.isNull()) {
				g.fillRect(r.x, r.y, r.width, r.height);
			}
		}
		
		if (aModel.isGameOver()) {
			Piece p = new Piece(1);
			p.setCol(1);
			p.setRow(1);
			if (!(aModel.getSelectedPiece() == null)) {
				if (aModel.getSelectedPiece().getCol() == 1 && aModel.getSelectedPiece().getRow() == 1) {
					p.setRow(0);
				}
			}
			if (aModel.getIsWinner()) {
				Font font = new Font("Arial", Font.BOLD, 70);
				g.setFont(font);
				g.setColor(Color.green);
				String s = "W";
				Rectangle r = compR(p);
				g.fillRect(r.x, r.y, r.width, r.height);
				g.setColor(Color.black);
				g.drawString(s, r.x + pieceSize / 2 - 16 * offset, r.y + pieceSize / 2 + 10 * offset);
			} else {
				Font font = new Font("Arial", Font.BOLD, 70);
				g.setFont(font);
				g.setColor(Color.red);
				String s = "L";
				Rectangle r = compR(p);
				g.fillRect(r.x, r.y, r.width, r.height);
				g.setColor(Color.black);
				g.drawString(s, r.x + pieceSize / 2 - 10 * offset, r.y + pieceSize / 2 + 10 * offset);
			}
		}
	}

}
