package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnCalculator implements PieceMovesCalculator {
    private final ChessGame.TeamColor color;

    public PawnCalculator(ChessGame.TeamColor color) {
        this.color = color;
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        Collection<ChessMove> newMoves = new ArrayList<>();
        int row;

        if (color == ChessGame.TeamColor.WHITE) {
            row = position.getRow() + 1;
        } else {
            row = position.getRow() + -1;
        }
        int col = position.getColumn();

        if (board.isInBounds(row, col)) {
            ChessPosition newPosition = new ChessPosition(row, col);
            if (board.getPiece(newPosition) == null) {
                if (position.getRow() == 8 || position.getRow() == 1) {
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
                } else {
                    newMoves.add(new ChessMove(position, newPosition, null));
                }

            }

        }
        return newMoves;
    }
}