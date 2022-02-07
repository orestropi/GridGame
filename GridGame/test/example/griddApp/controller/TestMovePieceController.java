package example.griddApp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.List;

import org.junit.jupiter.api.Test;

import gridApp.controller.MovePieceController;
import gridApp.controller.SelectPieceController;
import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.MoveType;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;
import gridApp.view.UpdateButtons;


public class TestMovePieceController extends AppTestCase {
	
	@Test
	public void testMove() {
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
		GridPuzzleApp app = new GridPuzzleApp(m);
		SelectPieceController spc = new SelectPieceController (m, app);
		Point pt = coordinateToPoint(new Coordinate(1,1));
		assertTrue (app.getPuzzlePanel().pointCoordinate(pt).equals(new Coordinate(1,1)));
		spc.process(pt);
		
		// now request move via MovePieceControllerm
		MovePieceController mpc = new MovePieceController(m, app);
		assertTrue (mpc.move(MoveType.Left));
		assertFalse (mpc.move(MoveType.Left));
		// validate piece has new value and old piece is null
		Piece aP = null;
		for(Piece s: aPuzzle) {
			if(s.contains(new Coordinate(1, 1)))
				aP = s;
		}
		Piece aQ = null;
		for (Piece s: aPuzzle) {
			if(s.contains(new Coordinate(0, 1))) {
				aQ = s;		
			}
		}
		assertTrue (aP == null);
		assertEquals (5, aQ.getNumVal());
		app.repaint();
		for (Piece s: aPuzzle) {
			if(!(s.contains(new Coordinate(0, 1)) || s.contains(new Coordinate(0, 2)))) {
				s.setNull(true);;		
			}
		}
		pt = coordinateToPoint(new Coordinate(0,2));
		assertTrue (app.getPuzzlePanel().pointCoordinate(pt).equals(new Coordinate(0,2)));
		spc.process(pt);
		assertTrue (mpc.move(MoveType.Up));
		

	}
}
