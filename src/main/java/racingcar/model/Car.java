package racingcar.model;

public class Car {

    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(String name, int position, MoveStrategy moveStrategy) {
        validateCarHasNoName(name);
        validateCarHasLongName(name);
        validateCarHasSpecialCharacter(name);
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
    }

    private void validateCarHasNoName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백을 허용하지 않습니다.");
        }
    }

    private void validateCarHasLongName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateCarHasSpecialCharacter(String name) {
        if (!name.matches("^[a-zA-Z0-9가-힣]*$")) {
            throw new IllegalArgumentException("자동차 이름에 특수문자는 허용되지 않습니다.");
        }
    }

    public void move() {
        if (moveStrategy.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
