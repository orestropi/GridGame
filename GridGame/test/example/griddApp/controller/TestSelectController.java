package example.griddApp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gridApp.controller.SelectPieceController;
import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;



public class TestSelectController extends AppTestCase {
	@Test
	public void testSelect() {	
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
		Point pt = coordinateToPoint(new Coordinate(0,2));
		assertTrue(app.getPuzzlePanel().pointCoordinate(pt).equals(new Coordinate(0,2)));
		
		spc.process(pt);
		
		Piece p1 = getPiece(new Coordinate(0, 2)).get(); 
		assertEquals (p1, m.getSelectedPiece());
		
		// this piece can only move left and right. ensure buttons are enabled/disabled
		assertFalse (app.getLeftBut().isEnabled());
		assertTrue (app.getRightBut().isEnabled());
		assertTrue (app.getUpBut().isEnabled());
		assertFalse (app.getDownBut().isEnabled());
	}
}
