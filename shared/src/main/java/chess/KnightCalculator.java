package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KnightCalculator implements PieceMovesCalculator {
        private static final int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {-1, 2}, {-1, -2}, {1, -2}};
        private final ChessGame.TeamColor color;

        public KnightCalculator(ChessGame.TeamColor color) {
            this.color = color;
        }

        @Override
        public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
            Collection<ChessMove> newMoves = new ArrayList<>();
            for (int[] direction : directions) {

                int row = position.getRow() + direction[0];
                int col = position.getColumn() + direction[1];

                if (board.isInBounds(row, col)) {

                    ChessPosition newPosition = new ChessPosition(row, col);
                    ChessPiece pieceAtPosition = board.getPiece(newPosition);

                    if (pieceAtPosition == null || pieceAtPosition.getTeamColor() != color) {
                        newMoves.add(new ChessMove(position, newPosition, null));
                    }
                }
            }
            return newMoves;
        }
    }
