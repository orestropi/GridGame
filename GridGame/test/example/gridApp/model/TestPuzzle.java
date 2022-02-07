package example.gridApp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridApp.model.Coordinate;
import gridApp.model.Puzzle;

class TestPuzzle {

	@Test
	public void testConst() {
		Puzzle p = new Puzzle(3, 4, 11);
		assertEquals (11, p.winNum);
		assertEquals (3, p.numColumns);
		assertEquals (4, p.numRows);
	}
}
