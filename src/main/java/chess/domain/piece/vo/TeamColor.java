package chess.domain.piece.vo;

public enum TeamColor {
    WHITE(),
    BLACK(),
    EMPTY()
    ;

    public boolean isBlack() {
        return this == BLACK;
    }

    public TeamColor nextTurn() {
        if (this == BLACK) {
            return WHITE;
        }
        return BLACK;
    }
}
