package racingcar.model;

public class BasicMoveStrategy implements MoveStrategy {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int REFERENCE_VALUE = 4;

    private NumberGenerator numberGenerator = new NumberGenerator();

    @Override
    public boolean isMove() {
        return numberGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER) >= REFERENCE_VALUE;
    }
}
