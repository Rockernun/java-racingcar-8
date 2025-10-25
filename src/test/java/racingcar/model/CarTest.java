package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 이름_공백_제한() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(" ", 0, () -> false))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_길이_제한() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car("이름이6자리", 0, () -> false))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름_특수문자_허용_불가() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> new Car("박병욱!", 0, () -> false))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }
}