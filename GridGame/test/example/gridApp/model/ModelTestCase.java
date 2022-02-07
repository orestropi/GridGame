package example.gridApp.model;

import java.util.Optional;

import org.junit.Before;

import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.Piece;
import gridApp.model.Puzzle;

public abstract class ModelTestCase {
	protected Model m;

	/** Helper test method for location a piece by a coordinate. */
	protected Optional<Piece> getPiece(Coordinate c) {
		for (Piece p : m.getaPuzzle()) {
			if (p.contains(c)) {
				return Optional.of(p);
			}
		}
		
		return Optional.empty(); 
	}
	
	@Before
	public void setUp() {
		m = new Model();
		Puzzle aPuzzle = new Puzzle(3,3,11);
		Piece p = new Piece(2);
		p.setMiddle(true);
		aPuzzle.add(p, 1, 1);
		
		aPuzzle.add(new Piece(1), 0, 0);
		aPuzzle.add(new Piece(4), 1, 0);
		aPuzzle.add(new Piece(3), 2, 0);
		
		aPuzzle.add(new Piece(7), 0, 1);
		aPuzzle.add(new Piece(5), 2, 1);
		
		aPuzzle.add(new Piece(9), 0, 2);
		aPuzzle.add(new Piece(8), 1, 2);
		aPuzzle.add(new Piece(6), 2, 2);
		m.setaPuzzle(aPuzzle);
	}

}
