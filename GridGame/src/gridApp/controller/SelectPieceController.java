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

public class SelectPieceController {
	Model aModel;
	GridPuzzleApp app;
	
	public SelectPieceController(Model m, GridPuzzleApp app) {
		this.aModel = m;
		this.app = app;

	}

	public void process(Point point) {
		if(aModel.isGameOver()) {return;}//checkGameOver
		Coordinate c = app.getPuzzlePanel().pointCoordinate(point);
		Puzzle aPuzzle = aModel.getaPuzzle();
		
		for (Piece p: aPuzzle) {
			if(p.contains(c)) {
				aModel.clearSelectedPiece();;				
				aModel.setSelectedPiece(p);
				List<MoveType> moves = aModel.availableMoves(p);
				UpdateButtons.enableButtons(app, moves);
				app.repaint();
				
			}
		}
	
	}

}
