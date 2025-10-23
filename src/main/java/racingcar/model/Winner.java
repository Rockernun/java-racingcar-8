package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private List<String> winners = new ArrayList<>();

    public List<String> selectWinners(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
