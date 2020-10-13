package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position pos = new Position(0, 0);

		// up up left
		pos.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// up up right
		pos.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// up left left
		pos.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// up right right
		pos.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down left left
		pos.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down right right
		pos.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down down left
		pos.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// down down right
		pos.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		return mat;
	}

	@Override
	public String toString() {
		return "H";
	}
}
