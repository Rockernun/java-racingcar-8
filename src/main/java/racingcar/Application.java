package racingcar;

import racingcar.controller.GameController;
import racingcar.model.BasicMoveStrategy;
import racingcar.model.MoveStrategy;
import racingcar.model.NumberGenerator;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator();
        MoveStrategy moveStrategy = new BasicMoveStrategy(numberGenerator);
        GameService gameService = new GameService(moveStrategy);
        GameController gameController = new GameController(inputView, outputView, gameService);

        gameController.run();
    }
}

