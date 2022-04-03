package chess.domain.piece;

import chess.domain.board.Position;
import chess.domain.piece.vo.TeamColor;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class Piece {

    final TeamColor teamColor;
    final Position position;

    Piece(final TeamColor teamColor, final Position position) {
        this.teamColor = teamColor;
        this.position = position;
    }

    public abstract Piece move(final List<Piece> otherPieces, final Position targetPosition);

    public final boolean hasPosition(final Position position) {
        return this.position == position;
    }

    public final boolean isBlackTeam() {
        return teamColor.isBlack();
    }

    final List<Position> convertToPositions(final List<Piece> pieces) {
        return pieces.stream()
                .map(piece -> piece.position)
                .collect(Collectors.toList());
    }

    public final boolean isSameTeam(final Piece anotherPiece) {
        return this.teamColor == anotherPiece.teamColor;
    }

    public final boolean isTypeOf(final Class<? extends Piece> pieceType) {
        return this.getClass().equals(pieceType);
    }

    public final boolean isTeamOf(final TeamColor teamColor) {
        return this.teamColor == teamColor;
    }

    public abstract double getScore();

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Piece piece = (Piece) o;
        return teamColor == piece.teamColor && Objects.equals(position, piece.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamColor, position);
    }

    public String getColor() {
        return teamColor.name();
    }
}
