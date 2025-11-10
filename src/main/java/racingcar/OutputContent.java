package racingcar;

public class OutputContent {
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printLine(){
        System.out.println();
    }

    public void printCarStatus(Car car){
        System.out.println(car.getStatus());
    }
}
