package example.gridApp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridApp.model.Coordinate;
import gridApp.model.Piece;

class TestPiece {

	@Test
	void testConstruct() {
		Piece piece = new Piece(6);
		piece.setCol(1);
		piece.setRow(2);
		assertEquals(1, piece.getCol());
		assertEquals(2, piece.getRow());
		assertEquals(6, piece.getNumVal());
		assertEquals(false, piece.isMiddle());
		assertEquals(false, piece.isNull());
		piece.setMiddle(true);
		piece.setNumVal(6);
		assertEquals(true, piece.isMiddle());
		assertEquals(6, piece.getNumVal());
		piece.setNull(true);
		assertEquals(true, piece.isNull());
	}
	
	@Test
	void testContains() {
		Piece p = new Piece (1);
		p.setRow(0);
		p.setCol(0);
		assertTrue(p.contains(new Coordinate(0, 0)));
		assertFalse(p.contains(new Coordinate(1, 0)));
		p.setNull(true);
		assertFalse(p.contains(new Coordinate(0, 0)));
		assertFalse(p.contains(new Coordinate(0, 1)));
	}
	
	@Test
	void testGetLocation() {
		Piece p = new Piece (1);
		p.setRow(0);
		p.setCol(2);
		Coordinate c = p.getLocation();
		assertEquals(0, p.getRow());
		assertEquals(2, p.getCol());
	}
	
	
	@Test
	void testCopy() {
		Piece p = new Piece (1);
		p.setCol(1);
		p.setRow(2);
		Piece p2 = p.copy();
		assertEquals(2, p.getRow());
		assertEquals(1, p.getCol());
		assertEquals(2, p.getRow());
		assertEquals(1, p.getCol());
	}


}
