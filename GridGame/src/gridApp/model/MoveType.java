package gridApp.model;

public enum MoveType {
	Up(0,-1), Down(0,1), Left(-1,0), Right(1,0),
	None(0,0);
	
	final int deltaC;
	final int deltaR;
	
	MoveType(int dc, int dr) {
		this.deltaR = dc;
		this.deltaC = dr;
	}

	public int getDeltaC() {
		return deltaC;
	}

	public int getDeltaR() {
		return deltaR;
	}
	

}
