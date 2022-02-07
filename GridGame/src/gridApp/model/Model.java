package gridApp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle aPuzzle;
	boolean gameOver;
	boolean isWinner;
	Piece selectedPiece;
	Piece targetPiece;

	
	/**
	 * (0,0) (1,0) (2,0)
	 * (0,1) (1,1) (2,1)
	 * (0,2) (1,2) (2,2)
	 */

	public Model() {}
	
	public boolean tryMove(MoveType dir) {
		if(selectedPiece == null) {return false;} //BEFORE: isnull()
		
		for(MoveType m : availableMoves()) {
			if(dir == m) {
				aPuzzle.move(dir,selectedPiece.getLocation());
				for(Piece p : aPuzzle.getPieces()) {
					if(p.contains(new Coordinate(selectedPiece.getCol() + m.deltaR,selectedPiece.getRow() + m.deltaC))) {
						targetPiece=p;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean checkGameOver() {
		boolean noMovesAvailable = true;
		for(Piece p : aPuzzle.getPieces()) {
		if(!availableMoves(p).isEmpty() && !p.isNull()) {
			noMovesAvailable=false;
		}}
		return noMovesAvailable;
	}
	
	public void endGame() {
		int inc = 0;
		for(Piece p : aPuzzle.getPieces()) {
			if(!p.isNull()) {
				inc++;
			}
			if(!p.isNull() && p.isMiddle() && p.getNumVal() == aPuzzle.getWinNum()) {
				isWinner = true;
			}
		}
		if(inc>1) {
			isWinner = false;
		}else {
			for(Piece p : aPuzzle.getPieces()) {
				if(!p.isNull()) {
					selectedPiece = p;
				}
			}
		}
		gameOver = true;	
	}
	
	public List<MoveType> availableMoves(){
		ArrayList<MoveType> moves = new ArrayList<>();
		if (selectedPiece == null) {
			return moves;
		}
		return availableMoves(selectedPiece);
		
	}
	
	public List<MoveType> availableMoves(Piece p){
		ArrayList<MoveType> moves = new ArrayList<>();
		
		Coordinate c = p.getLocation();
		//Up?
		
		boolean available = true;
		if (!aPuzzle.isAvailable(new Coordinate(c.col,c.row-1))) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Up);
		}
		//Right?
		available = true;
		if (!aPuzzle.isAvailable(new Coordinate(c.col+1,c.row))) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Right);
		}
		//Left?
		available = true;
		if (!aPuzzle.isAvailable(new Coordinate(c.col-1,c.row))) {
			available = false;
		}
		if (p.getNumVal() - aPuzzle.getVal(new Coordinate(c.col-1,c.row))>=0) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Left);
		}
		//Down?
		available = true;
		if (!aPuzzle.isAvailable(new Coordinate(c.col,c.row+1))) {
			available = false;
		}
		if (p.getNumVal() > aPuzzle.getVal(new Coordinate(c.col,c.row+1))) {
			available = false;
		}
		if (aPuzzle.getVal(new Coordinate(c.col,c.row+1)) % p.getNumVal() != 0) {
			available = false;
		}
		if(available) {
			moves.add(MoveType.Down);
		}		
		return moves;

	}


	public Puzzle getaPuzzle() {
		return aPuzzle;
	}

	public void setaPuzzle(Puzzle aPuzzle) {
		this.aPuzzle = aPuzzle;
	}
	
	public void clearSelectedPiece() {
		this.selectedPiece = null;
		targetPiece = null;
		gameOver = false;
		selectedPiece = null;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}
	
	public boolean isGameOver() {return gameOver;}

	public void setGameOver(boolean flag) {
		this.gameOver = flag;
	}
	
	public Piece getTargetPiece() {
		return targetPiece;
	}

	public void setTargetPiece(Piece targetPiece) {
		this.targetPiece = targetPiece;
	}

	public boolean getIsWinner() {return isWinner;}
	
	public void resetPuzzle() {
		aPuzzle.reset();
		selectedPiece = null;
		targetPiece = null;
		isWinner = false;
		gameOver = false;
	}

	
	
	
}
