package example.griddApp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import gridApp.controller.ExitController;
import gridApp.controller.ResetController;
import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.MoveType;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;
import gridApp.view.PuzzlePanel;



public class TestResetController extends AppTestCase {
	
	@Test
	public void testReset() {
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
		Piece p1 = this.getPiece(new Coordinate(1,1)).get(); // piece in bottom of '012' state
		m.setSelectedPiece(p1);
		assertTrue (m.tryMove(MoveType.Left));
		assertTrue (p1.isNull());
		ResetController rpc = new ResetController(m, app);
		rpc.reset();
		assertFalse (this.getPiece(new Coordinate(1,1)).get().isNull());
		assertFalse (getPiece(new Coordinate(0,4)).isPresent());  // no longer there
	}
	
	@Test
	public void testExit() {
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
		Piece p1 = this.getPiece(new Coordinate(1,1)).get(); // piece in bottom of '012' state
		m.setSelectedPiece(p1);
		assertTrue (m.tryMove(MoveType.Left));
		assertTrue (p1.isNull());
		ResetController rpc = new ResetController(m, app);
		rpc.reset();
		assertFalse (this.getPiece(new Coordinate(1,1)).get().isNull());
		assertFalse (getPiece(new Coordinate(0,4)).isPresent());  // no longer there
		PuzzlePanel aP = new PuzzlePanel(m);
		aP.repaint();
		
		ExitController epc = new ExitController(app);
		epc.exit();
	}
	

		
	}

