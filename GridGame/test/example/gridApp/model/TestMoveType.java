package example.gridApp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridApp.model.MoveType;

class TestMoveType {

	@Test
	public void testMove() {
		assertEquals (0, MoveType.Right.getDeltaC()); 
		assertEquals (1, MoveType.Right.getDeltaR());
	}

}
