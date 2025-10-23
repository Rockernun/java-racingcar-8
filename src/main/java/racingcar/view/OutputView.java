package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printProgress(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}