package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {

    @Test
    void 우승자_없음() {
        assertSimpleTest(() -> {
            Winner winner = new Winner();
            List<Car> cars = List.of(
                    new Car("자동차1", 0, () -> false),
                    new Car("자동차2", 0, () -> false),
                    new Car("자동차3", 0, () -> false)
            );

            assertThatThrownBy(() -> winner.getWinners(cars))
                    .isInstanceOf(IllegalStateException.class);
        });
    }

    @Test
    void 단일_우승() {
        assertSimpleTest(() -> {
            Winner winner = new Winner();
            List<Car> cars = List.of(
                    new Car("자동차1", 1, () -> false),
                    new Car("자동차2", 2, () -> false),
                    new Car("자동차3", 3, () -> false)
            );
            List<String> winners = winner.getWinners(cars);
            assertThat(winners).containsExactly("자동차3");
        });
    }

    @Test
    void 공동_우승() {
        assertSimpleTest(() -> {
            Winner winner = new Winner();
            List<Car> cars = List.of(
                    new Car("자동차1", 1, () -> false),
                    new Car("자동차2", 2, () -> false),
                    new Car("자동차3", 2, () -> false)
            );
            List<String> winners = winner.getWinners(cars);
            assertThat(winners).containsExactlyInAnyOrder("자동차2", "자동차3");
        });
    }
}