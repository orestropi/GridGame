package gridApp.controller;

import javax.swing.JOptionPane;

import gridApp.model.Model;
import gridApp.view.GridPuzzleApp;
import gridApp.view.UpdateButtons;

public class ExitController {
	Model aModel;
	GridPuzzleApp app;
	
	public ExitController(GridPuzzleApp app) {
		this.app = app;
	}

	public void exit() {
		int c = JOptionPane.showConfirmDialog(app, "Do you want to exit?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
