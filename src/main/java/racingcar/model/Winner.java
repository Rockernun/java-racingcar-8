package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<String> winners = new ArrayList<>();

    private int findLargestPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        if (max == 0) {
            throw new IllegalStateException("어떤 자동차도 전진하지 않으면, 우승자를 선정할 수 없습니다. 게임을 다시 진행해주세요.");
        }

        return max;
    }

    public List<String> getWinners(List<Car> cars) {
        for (Car car : cars) {
            if (car.getPosition() == findLargestPosition(cars)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
