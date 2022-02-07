package example.griddApp.controller;

import java.awt.Point;

import org.junit.*;
import example.gridApp.model.ModelTestCase;
import gridApp.model.Coordinate;
import gridApp.view.GridPuzzleApp;
import gridApp.view.PuzzlePanel;



public abstract class AppTestCase extends ModelTestCase {

	protected GridPuzzleApp app;
	
	@Before
	public void createApp() {
		app = new GridPuzzleApp(m);
		app.setVisible(true);
	}
	
	@After
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.pieceSize, c.row * PuzzlePanel.pieceSize);
	}
}
