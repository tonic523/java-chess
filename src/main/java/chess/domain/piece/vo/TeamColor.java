package chess.domain.piece.vo;

import chess.domain.board.Rank;
import java.util.Arrays;
import java.util.function.Predicate;

public enum TeamColor {
    WHITE(rank -> rank == Rank.ONE || rank == Rank.TWO),
    BLACK(rank -> rank == Rank.SEVEN || rank == Rank.EIGHT),
    ;

    private final Predicate<Rank> rankPredicate;

    TeamColor(final Predicate<Rank> rankPredicate) {
        this.rankPredicate = rankPredicate;
    }

    public static TeamColor findByRank(final Rank rank) {
        return Arrays.stream(values())
                .filter(teamColor -> teamColor.rankPredicate.test(rank))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("팀 컬러를 식별할 수 있는 Rank는 1,2,7,8 입니다."));
    }

    public boolean isBlack() {
        return this == BLACK;
    }

    public TeamColor nextTurn() {
        if (this == BLACK) {
            return WHITE;
        }
        return BLACK;
    }

    public String getColor() {
        return this.toString();
    }
}
