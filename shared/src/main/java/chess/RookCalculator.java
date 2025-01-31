package chess;

import java.util.Collection;
import java.util.ArrayList;

public class RookCalculator implements PieceMovesCalculator {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final ChessGame.TeamColor color;

    public RookCalculator(ChessGame.TeamColor color) {
        this.color = color;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> newMoves = new ArrayList<>();

        for (int[] direction : directions) {

            int row = position.getRow() + direction[0];
            int col = position.getColumn() + direction[1];

            while (board.isInBounds(row, col)) {
                ChessPosition newPosition = new ChessPosition(row, col);
                ChessPiece pieceAtPosition = board.getPiece(newPosition);

                if (pieceAtPosition == null) {
                    newMoves.add(new ChessMove(position, newPosition, null));
                } else {
                    if (pieceAtPosition.getTeamColor() != color) {
                        newMoves.add(new ChessMove(position, newPosition, null));
                    }
                    break;
                }

                row += direction[0];
                col += direction[1];
            }
        }
        return newMoves;
    }
}