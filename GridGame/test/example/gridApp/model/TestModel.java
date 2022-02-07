package example.gridApp.model;

import org.junit.Test;

import gridApp.model.Coordinate;
import gridApp.model.MoveType;
import gridApp.model.Piece;
import gridApp.view.UpdateButtons;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TestModel extends ModelTestCase {

	@Test
	public void testInitialState() {
		assertTrue (m.getSelectedPiece() == null);
		assertEquals(0, m.availableMoves().size());
	}
	@Test
	public void testPossibleMove() {
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.clearSelectedPiece();				
		m.setSelectedPiece(p);
		List<MoveType> available = m.availableMoves();
		assertEquals (4, available.size());
		assertTrue (available.contains(MoveType.Left));
		assertTrue (available.contains(MoveType.Right));
		assertTrue (available.contains(MoveType.Down));
		assertTrue (available.contains(MoveType.Up));
	}
	
	@Test
	public void testMove() {
		List<MoveType> available = m.availableMoves();
		assertEquals (0, available.size());
		assertFalse (m.tryMove(MoveType.Up));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.setSelectedPiece(p);
		m.availableMoves();
		assertTrue (m.tryMove(MoveType.Up));
		Piece a = this.getPiece(new Coordinate(1, 0)).get(); 
		assertEquals (8, a.getNumVal());
		m.setTargetPiece(a);
		assertEquals (a, m.getTargetPiece());
	}
	
	@Test
	public void testBadMoves() {
		Piece p = this.getPiece(new Coordinate(2,0)).get(); 
		m.setSelectedPiece(p);
		assertEquals (1, m.availableMoves().size());
		
		p = this.getPiece(new Coordinate(0,0)).get(); 
		m.setSelectedPiece(p);
		assertEquals (2, m.availableMoves().size());
	}
	@Test
	public void testResetUp() {
		assertFalse (m.tryMove(MoveType.Up));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.setSelectedPiece(p);
		assertTrue (m.tryMove(MoveType.Up));
		Piece a = this.getPiece(new Coordinate(1, 0)).get(); 
		assertEquals (8, a.getNumVal());
		assertTrue(p.isNull());
		
		m.resetPuzzle();
		a = this.getPiece(new Coordinate(1, 0)).get(); 
		assertEquals (4, a.getNumVal());
		p = this.getPiece(new Coordinate(1, 1)).get(); 
		assertEquals (2, p.getNumVal());
		assertFalse(p.isNull());
	}
	@Test
	public void testResetDown() {
		assertFalse (m.tryMove(MoveType.Down));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.setSelectedPiece(p);
		assertTrue (m.tryMove(MoveType.Down));
		Piece a = this.getPiece(new Coordinate(1, 2)).get(); 
		assertEquals (4, a.getNumVal());
		assertTrue(p.isNull());
		
		m.resetPuzzle();
		a = this.getPiece(new Coordinate(1, 2)).get(); 
		assertEquals (8, a.getNumVal());
		p = this.getPiece(new Coordinate(1, 1)).get(); 
		assertEquals (2, p.getNumVal());
		assertFalse(p.isNull());
	}
	@Test
	public void testResetLeft() {
		assertFalse (m.tryMove(MoveType.Left));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.setSelectedPiece(p);
		assertTrue (m.tryMove(MoveType.Left));
		Piece a = this.getPiece(new Coordinate(0, 1)).get(); 
		assertEquals (5, a.getNumVal());
		assertTrue(p.isNull());
		
		m.resetPuzzle();
		a = this.getPiece(new Coordinate(0, 1)).get(); 
		assertEquals (7, a.getNumVal());
		p = this.getPiece(new Coordinate(1, 1)).get(); 
		assertEquals (2, p.getNumVal());
		assertFalse(p.isNull());
	}
	@Test
	public void testResetRight() {
		assertFalse (m.tryMove(MoveType.Right));  // nothing selected? No moves vailable.
		Piece p = this.getPiece(new Coordinate(1, 1)).get(); 
		m.setSelectedPiece(p);
		assertTrue (m.tryMove(MoveType.Right));
		Piece a = this.getPiece(new Coordinate(2, 1)).get(); 
		assertEquals (7, a.getNumVal());
		assertTrue(p.isNull());
		
		m.resetPuzzle();
		a = this.getPiece(new Coordinate(2, 1)).get(); 
		assertEquals (5, a.getNumVal());
		p = this.getPiece(new Coordinate(1, 1)).get(); 
		assertEquals (2, p.getNumVal());
		assertFalse(p.isNull());
	}
	
	@Test
	public void testWin() {
		assertFalse (m.isGameOver());
		m.setGameOver(true);
		assertTrue (m.isGameOver());
		m.setGameOver(false);
		assertFalse(m.checkGameOver());
		m.endGame();
		assertFalse(m.getIsWinner());

//		assertFalse (m.isWinCondition(MoveType.Left));
//		Piece p = this.getPiece(new Coordinate(2, 0)).get();
//		assertTrue (p.isWinner);
//		
//		m.setSelectedPiece(p);
//		
//		assertFalse (m.isWinCondition(MoveType.Down));
	}
}
