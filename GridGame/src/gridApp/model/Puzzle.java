package gridApp.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Piece> {
	ArrayList<Piece> pieces = new ArrayList<>();
	
	ArrayList<Piece> originals = new ArrayList<>();
	public final int numColumns;
	public final int numRows;
	public final int winNum;//

	
	public Puzzle(int numColumns, int numRows, int winNum) {
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.winNum = winNum;
		
	}
	
	public ArrayList<Piece> getPieces(){return pieces;}
	

	public int getWinNum() {
		return winNum;
	}

	public void add(Piece p, int col, int row) {
		p.setCol(col);
		p.setRow(row);
		pieces.add(p);
		originals.add(p.copy());
	}
	
	public int getVal(Coordinate c) {
		for(Piece p : pieces) {
			if(p.contains(c)) {
				return p.getNumVal();
			}
		}
		return -1;
	}
	
	public boolean isAvailable(Coordinate c) {
		for(Piece p : pieces) {
			if(p.contains(c) && !p.isNull()) {
				return true;
			}
		}
		return false;
	}
	
	public void move(MoveType dir, Coordinate c) {
		if(dir == MoveType.None) {return;}
		int aCol = 0;
		int aRow = 0;
		int numValOG = 0;
		for(Piece p : pieces) {
			if(p.contains(c) && !p.isNull()) {
				numValOG = p.getNumVal();
				p.setNull(true);
				aCol = p.col + dir.deltaR;
				aRow = p.row + dir.deltaC;
			}
		}
		Coordinate nextC = new Coordinate(aCol, aRow);
		if(dir == MoveType.Up) {
			for(Piece p : pieces) {
				if(p.contains(nextC) && !p.isNull()) {
					p.setNumVal(p.getNumVal()*numValOG);
				}
			}
		}
		if(dir == MoveType.Right) {
			for(Piece p : pieces) {
				if(p.contains(nextC) && !p.isNull()) {
					p.setNumVal(p.getNumVal()+numValOG);
				}
			}
		}
		if(dir == MoveType.Left) {
			for(Piece p : pieces) {
				if(p.contains(nextC) && !p.isNull()) {
					p.setNumVal(p.getNumVal()-numValOG);
				}
			}
		}
		if(dir == MoveType.Down) {
			for(Piece p : pieces) {
				if(p.contains(nextC) && !p.isNull()) {
					p.setNumVal(p.getNumVal()/numValOG);
				}
			}
		}
		
	}

	@Override
	public Iterator<Piece> iterator() {
		return pieces.iterator();
	}

	public void reset() {
		pieces.clear();
		for(Piece p : originals) {
			pieces.add(p.copy());
		}
		
	}
	
	

}
