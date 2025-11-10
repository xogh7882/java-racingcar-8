package racingcar;

public class RacingGameController {
    private final InputContent inputContent;
    private final OutputContent outputContent;

    public RacingGameController(){
        this.inputContent = new InputContent();
        this.outputContent = new OutputContent();
    }

    public void run(){
        String carNames = inputContent.inputCarName();
        int racingCount = inputContent.inputRacingCount();

        Cars cars = new Cars(carNames);

        outputContent.printResult();
        for (int i = 0; i < racingCount; i++) {
            cars.race(outputContent);
            outputContent.printLine();
        }

        outputContent.printWinners(cars.getWinner());
    }
}
