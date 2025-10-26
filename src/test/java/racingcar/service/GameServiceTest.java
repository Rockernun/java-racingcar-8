package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void 자동차_이름_중복() {
        assertSimpleTest(() -> {
            GameService gameService = new GameService(() -> false);
            assertThatThrownBy(() -> gameService.initCarList("pobi,woni,pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 공백_포함_중복() {
        assertSimpleTest(() -> {
            GameService gameService = new GameService(() -> false);
            assertThatThrownBy(() -> gameService.initCarList("pobi, pobi"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 시도횟수_숫자() {
        assertSimpleTest(() -> {
            GameService gameService = new GameService(() -> false);
            assertThatThrownBy(() -> gameService.validateRoundIsPositive("rockernun"))
                    .isInstanceOf(NumberFormatException.class);
            assertThatThrownBy(() -> gameService.validateRoundIsPositive("a1b2c3"))
                    .isInstanceOf(NumberFormatException.class);
            assertThatThrownBy(() -> gameService.validateRoundIsPositive(" "))
                    .isInstanceOf(NumberFormatException.class);
        });
    }

    @Test
    void 시도횟수_양수() {
        GameService gameService = new GameService(() -> false);
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> gameService.validateRoundIsPositive("0"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> gameService.validateRoundIsPositive("-1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

}