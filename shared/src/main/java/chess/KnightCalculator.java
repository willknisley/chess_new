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


    }
