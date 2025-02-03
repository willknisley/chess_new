package chess;

import java.util.ArrayList;
import java.util.Collection;

public class BishopCalculator implements PieceMovesCalculator {

    public static final int[][] directions = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    private final ChessGame.TeamColor color;

    public BishopCalculator(ChessGame.TeamColor color) {
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
