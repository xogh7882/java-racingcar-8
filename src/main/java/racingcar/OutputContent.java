package racingcar;

import java.util.List;

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

    public void printWinners(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
