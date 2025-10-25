package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    @Test
    void 범위_내_숫자_생성() {
        NumberGenerator gen = new NumberGenerator();
        for (int i = 0; i < 1000; i++) {
            int n = gen.generateNumber(0, 9);
            assertThat(n).isBetween(0, 9);
        }
    }

    @Test
    void 잘못된_범위_예외() {
        NumberGenerator gen = new NumberGenerator();
        assertThatThrownBy(() -> gen.generateNumber(10, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}