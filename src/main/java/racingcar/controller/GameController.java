package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;
    private final Winner winner = new Winner();

    public GameController(InputView inputView, OutputView outputView, GameService gameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameService;
    }

    public void run() {
        List<Car> cars = gameService.initCarList(inputView.inputCarNames());
        int rounds = gameService.validateRoundIsPositive(inputView.inputRounds());

        System.out.println("실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
                outputView.printProgress(car);
            }

            System.out.println();
        }

        outputView.printWinners(winner.getWinners(cars));
    }
}
