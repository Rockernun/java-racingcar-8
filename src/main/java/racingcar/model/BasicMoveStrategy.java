package racingcar.model;

public class BasicMoveStrategy implements MoveStrategy {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int REFERENCE_VALUE = 4;

    private NumberGenerator numberGenerator = new NumberGenerator();

    @Override
    public boolean isMove() {
        return numberGenerator.generateNumber() >= REFERENCE_VALUE;
    }
}
