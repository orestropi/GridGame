package example.Panel;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.*;
import org.junit.jupiter.api.Test;

import gridApp.model.Model;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;



public class TestPanel {

	Model model;
	GridPuzzleApp app;
	
	@Before
	public void setUp() {
		model = new Model();
		app = new GridPuzzleApp(model);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() {
		try { 
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		app.setVisible(false);
	}
	
	// not much you can really do here other than ensure doesn't crash.
	@Test
	public void testDrawingWorks() {
		model = new Model();
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
		model.setaPuzzle(aPuzzle);
		Piece p2 = new Piece(2);
		p2.setCol(1);
		p2.setRow(1);
		model.setSelectedPiece(p2);
		model.setTargetPiece(p2);
		GridPuzzleApp app = new GridPuzzleApp(model);
		app.setVisible(true);
		Point p1 = new Point (30, 60);
		//Oval o = new Oval(p, 10, 20);
		
		//model.addOval(o);
		model.setGameOver(true);
		app.getPuzzlePanel().repaint();
		System.out.println("Drawn");
		
	}
}
