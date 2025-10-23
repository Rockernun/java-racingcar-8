package racingcar.model;

import static racingcar.model.BasicMoveStrategy.MAX_NUMBER;
import static racingcar.model.BasicMoveStrategy.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
