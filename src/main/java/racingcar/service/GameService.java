package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.MoveStrategy;

public class GameService {

    private final MoveStrategy moveStrategy;

    public GameService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public List<Car> initCarList(String input) {
        String[] split = input.split(",");
        List<Car> carList = new ArrayList<>();
        for (String s : split) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carList.add(new Car(s, 0, moveStrategy));
        }

        return carList;
    }
}
