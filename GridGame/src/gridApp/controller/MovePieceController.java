package gridApp.controller;

import java.util.ArrayList;
import java.util.List;

import gridApp.model.Model;
import gridApp.model.MoveType;
import gridApp.view.GridPuzzleApp;
import gridApp.view.UpdateButtons;

public class MovePieceController {
	Model aModel;
	GridPuzzleApp app;
	
	public MovePieceController(Model m, GridPuzzleApp app) {
		this.aModel = m;
		this.app = app;

	}
	
	public boolean move(MoveType dir) {
		if(aModel.getSelectedPiece().isNull()) {return false;}
		
		if (aModel.tryMove(dir)) {
			ArrayList<MoveType> moves = new ArrayList<>();
			moves.add(dir);
			UpdateButtons.enableButtons(app, moves);
		}
		if(aModel.checkGameOver()) {
			ArrayList<MoveType> moves = new ArrayList<>();
			aModel.endGame();
			UpdateButtons.enableButtons(app, moves);
		}
		app.repaint();

		return true;
		
	}
}
