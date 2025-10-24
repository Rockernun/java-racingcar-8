package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    public int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
