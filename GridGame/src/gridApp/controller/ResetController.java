package gridApp.controller;

import java.awt.Point;
import java.util.List;

import gridApp.model.Coordinate;
import gridApp.model.Model;
import gridApp.model.MoveType;
import gridApp.model.Piece;
import gridApp.model.Puzzle;
import gridApp.view.GridPuzzleApp;
import gridApp.view.UpdateButtons;

public class ResetController {
	Model aModel;
	GridPuzzleApp app;
	
	public ResetController(Model m, GridPuzzleApp app) {
		this.aModel = m;
		this.app = app;

	}

	public void reset() {
		aModel.resetPuzzle();
		UpdateButtons.enableButtons(app, aModel.availableMoves());
		app.repaint();
	}
}
