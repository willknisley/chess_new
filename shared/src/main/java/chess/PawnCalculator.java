package chess;

import java.util.ArrayList;
import java.util.Collection;

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
                if (row == 7 || row == 2) {
                    row = position.getRow() + 2 * row;
                    if (board.isInBounds(row, col)) {
                        ChessPosition secondPosition = new ChessPosition(row, col);
                        if (board.getPiece(secondPosition) == null) {
                            newMoves.add(new ChessMove(position, secondPosition, null));
                        }
                    }
                } else if (row == 8 || row == 1) {
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
                } else {
                    newMoves.add(new ChessMove(position, newPosition, null));
                }


                int newRow, newCol;
                if (board.getPiece(newPosition) != null && board.getPiece(newPosition).getTeamColor() != color) {
                    if (color == ChessGame.TeamColor.WHITE) {
                        newRow = row + 1;
                        newCol = col + 1;
                    } else {
                        newRow = row - 1;
                        newCol = row - 1;
                    }
                    if (board.isInBounds(newRow, newCol)) {
                        if (newRow == 8 || newRow == 1) {
                            newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                            newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                            newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                            newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
                        } else {
                            newMoves.add(new ChessMove(position, newPosition, null));
                        }
                    }
                }
            }

        }
        return newMoves;
    }
}

