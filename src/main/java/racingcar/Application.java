package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputContent inputContent = new InputContent();
        OutputContent outputContent = new OutputContent();

        String input = inputContent.inputCarName();
        int count = inputContent.inputRacingCount();

        Cars cars = new Cars(input);

        outputContent.printResult();
        for (int i = 0; i < count; i++) {
            cars.race();
            System.out.println();
        }

        cars.printWinner();
    }
}
