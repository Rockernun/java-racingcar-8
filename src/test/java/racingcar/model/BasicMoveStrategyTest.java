package racingcar.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BasicMoveStrategyTest {
    static class FixedNumberGenerator extends NumberGenerator {
        private final int fixedNumber;
        int min;
        int max;

        FixedNumberGenerator(int fixedNumber) {
            this.fixedNumber = fixedNumber;
        }

        @Override
        public int generateNumber(int min, int max) {
            this.min = min;
            this.max = max;
            return fixedNumber;
        }
    }

    @Test
    void 기준값_미만_전진_불가() {
        assertSimpleTest(() -> {
            FixedNumberGenerator generator = new FixedNumberGenerator(1);
            BasicMoveStrategy moveStrategy = new BasicMoveStrategy(generator);

            assertThat(moveStrategy.isMove()).isFalse();
            assertThat(generator.min).isEqualTo(0);
            assertThat(generator.max).isEqualTo(9);
        });
    }

    @Test
    void 기준값_이상_전진() {
        assertSimpleTest(() -> {
            FixedNumberGenerator generator = new FixedNumberGenerator(7);
            BasicMoveStrategy moveStrategy = new BasicMoveStrategy(generator);

            assertThat(moveStrategy.isMove()).isTrue();
            assertThat(generator.min).isEqualTo(0);
            assertThat(generator.max).isEqualTo(9);
        });
    }
}