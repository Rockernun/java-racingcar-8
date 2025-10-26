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
        for (String s : input.split(",")) {
            String name = s.trim();
            if (!name.isEmpty()) {
                carNames.add(name);
            }
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

    private int validateRoundIsInteger(String input) {
        String trim = input.trim();
        if (!trim.matches("[0-9]+$")) {
            throw new NumberFormatException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        return Integer.parseInt(trim);
    }

    public int validateRoundIsPositive(String input) {
        int round = validateRoundIsInteger(input);
        if (round <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양수만 입력 가능합니다.");
        }

        return round;
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
