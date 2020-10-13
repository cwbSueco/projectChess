package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position pos = new Position(0, 0);

		// white
		if (getColor() == Color.WHITE) {
			// first move
			if (getMoveCount() == 0) {
				Position p = new Position(position.getRow() - 1, position.getColumn());
				pos.setValues(position.getRow() - 2, position.getColumn());
				if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos) && getBoard().positionExists(p)
						&& !getBoard().thereIsAPiece(p)) {
					mat[pos.getRow()][pos.getColumn()] = true;
				}
			}
			// up
			pos.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			// up left
			pos.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			// up right
			pos.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}

			// en passant
			if (chessMatch.getEnPassantVulnerable() != null) {
				ChessPiece enPassantVulnerable = chessMatch.getEnPassantVulnerable();
				Position p = new Position(0, 0);

				// left
				pos.setValues(position.getRow(), position.getColumn() - 1);
				p.setValues(pos.getRow() - 1, pos.getColumn());
				if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)
						&& getBoard().piece(pos) == enPassantVulnerable && !getBoard().thereIsAPiece(p)
						&& getBoard().positionExists(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				// right
				pos.setValues(position.getRow(), position.getColumn() + 1);
				p.setValues(pos.getRow() - 1, pos.getColumn());
				if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)
						&& getBoard().piece(pos) == enPassantVulnerable && !getBoard().thereIsAPiece(p)
						&& getBoard().positionExists(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
		}

		// black
		else {
			// first move
			if (getMoveCount() == 0) {
				Position p = new Position(position.getRow() + 1, position.getColumn());
				pos.setValues(position.getRow() + 2, position.getColumn());
				if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos) && getBoard().positionExists(p)
						&& !getBoard().thereIsAPiece(p)) {
					mat[pos.getRow()][pos.getColumn()] = true;
				}
			}
			// down
			pos.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			// down left
			pos.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			// down right
			pos.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}

			// en passant
			if (chessMatch.getEnPassantVulnerable() != null) {
				ChessPiece enPassantVulnerable = chessMatch.getEnPassantVulnerable();
				Position p = new Position(0, 0);

				// left
				pos.setValues(position.getRow(), position.getColumn() - 1);
				p.setValues(pos.getRow() + 1, pos.getColumn());
				if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)
						&& getBoard().piece(pos) == enPassantVulnerable && !getBoard().thereIsAPiece(p)
						&& getBoard().positionExists(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}

				// right
				pos.setValues(position.getRow(), position.getColumn() + 1);
				p.setValues(pos.getRow() + 1, pos.getColumn());
				if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)
						&& getBoard().piece(pos) == enPassantVulnerable && !getBoard().thereIsAPiece(p)
						&& getBoard().positionExists(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
		}

		return mat;

	}

	@Override
	public String toString() {
		return "P";
	}
}
