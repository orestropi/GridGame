package gridApp.view;

import java.util.List;

import gridApp.model.MoveType;

public class UpdateButtons {
	public static void enableButtons(GridPuzzleApp app, List<MoveType> moves) {
		app.getUpBut().setEnabled(false);
		app.getRightBut().setEnabled(false);
		app.getLeftBut().setEnabled(false);
		app.getDownBut().setEnabled(false);
		
		for (MoveType m : moves) {
			if(m == MoveType.Up) {
			app.getUpBut().setEnabled(true);
			}else if(m == MoveType.Right) {
				app.getRightBut().setEnabled(true);
				}else if(m == MoveType.Left) {
					app.getLeftBut().setEnabled(true);
				}else if(m == MoveType.Down) {
					app.getDownBut().setEnabled(true);
				}
		}

	}

}
