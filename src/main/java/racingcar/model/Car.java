package racingcar.model;

public class Car {

    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;

    public Car(String name, int position, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = position;
        this.moveStrategy = moveStrategy;
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
