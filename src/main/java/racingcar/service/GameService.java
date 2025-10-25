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

    private List<String> parseCarNames(String input) {
        List<String> carNames = new ArrayList<>();
        String[] split = input.split(",");

        for (String s : split) {
            carNames.add(s);
        }

        return carNames;
    }

    public List<Car> initCarList(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차를 1대 이상 입력해야 합니다.");
        }

        List<String> nameList = parseCarNames(input);
        List<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            carList.add(new Car(name, 0, moveStrategy));
        }

        return carList;
    }
}
