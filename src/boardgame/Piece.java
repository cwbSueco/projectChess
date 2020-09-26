package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
//		position = null;
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}
	
//	public abstract Piece[][] possibleMove();

	public Boolean possibleMove(Position position) {
		return true;
	}
	
	public Boolean isThereAnyPossibleMove() {
		return true;
	}
	
}
