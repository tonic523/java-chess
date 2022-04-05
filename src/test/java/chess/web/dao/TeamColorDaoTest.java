package chess.web.dao;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.piece.vo.TeamColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TeamColorDaoTest {

    @Test
    @DisplayName("현재 턴인 색깔을 최신화한다.")
    void findCurrentTeamColor() {
        TeamColorDao.update(TeamColor.BLACK);
    }

    @Test
    @DisplayName("현재 턴인 색깔을 가져온다.")
    void findCurrentTurnTeamColor() {
        TeamColorDao.update(TeamColor.WHITE);
        assertThat(TeamColorDao.findCurrentTurn()).isEqualTo(TeamColor.WHITE);
    }

}
