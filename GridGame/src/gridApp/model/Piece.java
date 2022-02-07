package gridApp.model;

public class Piece {
	boolean isMiddle;
	boolean isNull;
	int numVal;	
	int col;
	int row;
	
	public Piece(int numVal) {
		this.numVal = numVal;
	}
	
	public boolean isNull() { return isNull;}
	public void setNull(boolean flag) { isNull = flag;}

	public int getNumVal() {
		return numVal;
	}

	public void setNumVal(int numVal) {
		this.numVal = numVal;
	}

	public boolean isMiddle() {
		return isMiddle;
	}

	public void setMiddle(boolean isMiddle) {
		this.isMiddle = isMiddle;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public Coordinate getLocation() {
		return new Coordinate(col, row);
	}

	public boolean contains(Coordinate c) {
		if(c.col == col && c.row == row && isNull == false) {
			return true;
		}
		else return false;
	}

	public Piece copy() {
		Piece p =  new Piece(numVal);
		p.setRow(row);
		p.setCol(col);
		p.setMiddle(isMiddle);
		return p;
	}


	

}
