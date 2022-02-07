package gridApp;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import gridApp.controller.ExitController;
import gridApp.model.Model;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;
/**
 *Orest Ropi IP2, CS3733
 *Credit to George Heineman, as parts of this code design are from his IP2 SlidingApp Code
 */
public class Main{
public static void main(String[] args) {
	Model m = new Model();
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
	
	app.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we) {
			new ExitController(app).exit();
		}
	});
	app.setVisible(true);
}
}
