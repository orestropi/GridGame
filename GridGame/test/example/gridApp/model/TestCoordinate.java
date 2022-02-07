package example.gridApp.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gridApp.model.Coordinate;

class TestCoordinate {

	@Test
	void testToString() {
		Coordinate c = new Coordinate(1, 2);
		assertEquals("(1, 2)", c.toString());
	}

}
