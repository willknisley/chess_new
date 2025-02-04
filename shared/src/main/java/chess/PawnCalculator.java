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
        int startRow;

        if (color == ChessGame.TeamColor.WHITE) {
            row = position.getRow() + 1;
        } else {
            row = position.getRow() + -1;
        }
        int col = position.getColumn();

        if (board.isInBounds(position.getRow(), col)) {
            ChessPosition newPosition = new ChessPosition(row, col);
            if (board.getPiece(newPosition) == null) {
                if ((position.getRow() == 2) || (position.getRow() == 7)) {
                    if (color == ChessGame.TeamColor.BLACK) {
                        startRow = position.getRow() - 2;
                    } else {
                        startRow = position.getRow() + 2;
                    }
                    if (board.isInBounds(startRow, col)) {
                        ChessPosition secondPosition = new ChessPosition(startRow, col);
                        if (board.getPiece(secondPosition) == null) {
                            newMoves.add(new ChessMove(position, secondPosition, null));
                        }
                    }
                }

                if (row == 8 || row == 1) {
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.QUEEN));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.ROOK));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.BISHOP));
                    newMoves.add(new ChessMove(position, newPosition, ChessPiece.PieceType.KNIGHT));
                } else {
                    newMoves.add(new ChessMove(position, newPosition, null));
                }

            }

            int leftCol = col - 1;
            int rightCol = col + 1;

            if (board.isInBounds(row, leftCol)) {
                ChessPosition thirdPosition = new ChessPosition(row, leftCol);
                ChessPiece diagPiece = board.getPiece(thirdPosition);
                if (diagPiece != null && diagPiece.getTeamColor() != color) {
                    if (row == 8 || row == 1) {
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.QUEEN));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.ROOK));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.BISHOP));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.KNIGHT));
                    } else {
                        newMoves.add(new ChessMove(position, thirdPosition, null));
                    }
                }
            }

            if (board.isInBounds(row, rightCol)) {
                ChessPosition thirdPosition = new ChessPosition(row, rightCol);
                ChessPiece diagPiece = board.getPiece(thirdPosition);
                if (diagPiece != null && diagPiece.getTeamColor() != color) {
                    if (row == 8 || row == 1) {
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.QUEEN));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.ROOK));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.BISHOP));
                        newMoves.add(new ChessMove(position, thirdPosition, ChessPiece.PieceType.KNIGHT));
                    } else {
                        newMoves.add(new ChessMove(position, thirdPosition, null));
                    }
                }
            }
        }
        return newMoves;
    }
}

