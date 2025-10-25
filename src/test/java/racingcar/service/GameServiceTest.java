package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameServiceTest {

    @Test
    void 이름_5자_초과() {
        assertSimpleTest(() -> {
            GameService gameService = new GameService(() -> true);
            assertThrows(IllegalArgumentException.class, () ->
                    gameService.initCarList("이름이6자리"));
        });
    }

    @Test
    void 이름_입력없음() {
        assertSimpleTest(() -> {
            GameService gameService = new GameService(() -> true);
            assertThrows(IllegalArgumentException.class, () ->
                    gameService.initCarList(""));
        });
    }
}