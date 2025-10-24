package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    private int findLargestPosition(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
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
