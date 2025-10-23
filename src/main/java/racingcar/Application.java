package racingcar;

import racingcar.controller.GameController;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameService gameService = new GameService();
        GameController gameController = new GameController(inputView, outputView, gameService);

        gameController.run();
    }
}

