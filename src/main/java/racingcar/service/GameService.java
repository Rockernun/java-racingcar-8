package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.BasicMoveStrategy;
import racingcar.model.Car;

public class GameService {

    public List<Car> initCarList(String input) {
        String[] split = input.split(",");
        List<Car> carList = new ArrayList<>();
        for (String s : split) {  // s는 분리된 자동차 이름 하나
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carList.add(new Car(s, 0, new BasicMoveStrategy()));
        }

        return carList;
    }
}
