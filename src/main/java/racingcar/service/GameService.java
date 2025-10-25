package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

    private List<String> validateDuplicateCarName(String input) {
        Set<String> set = new LinkedHashSet<>();
        for (String name : parseCarNames(input)) {
            if (!set.add(name)) {
                throw new IllegalArgumentException("차 이름이 중복되었습니다.");
            }
        }

        return new ArrayList<>(set);
    }

    public List<Car> initCarList(String input) {
        List<String> nameList = validateDuplicateCarName(input);
        List<Car> carList = new ArrayList<>();

        for (String name : nameList) {
            carList.add(new Car(name, 0, moveStrategy));
        }

        return carList;
    }
}
