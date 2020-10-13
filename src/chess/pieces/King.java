package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position pos = new Position(0, 0);

		// up
		pos.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// left
		pos.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down
		pos.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// right
		pos.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// up left
		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down left
		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down right
		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// up right
		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// kingside rook
			Position kingRook = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(kingRook)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 2);
				Position p2 = new Position(position.getRow(), position.getColumn() + 1);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// queenside rook
			Position queenRook = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(queenRook)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 3);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 1);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return mat;
	}

	@Override
	public String toString() {
		return "K";
	}
}
