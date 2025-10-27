package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    private List<Car> cars;
    private int winStep;

    public Cars(String input){
        this.cars = splitCars(input);
    }

    private List<Car> splitCars(String input){
        String trimInput = input.replace(",","").trim();
        if(trimInput.isEmpty()){
            throw new IllegalArgumentException("Input cannot be empty");
        }
        List<String> names = List.of(input.split(","));
        List<Car> carList = new ArrayList<>();
        for(String name : names){
            checkName(name);
            carList.add(new Car(name));
        }
        return carList;
    }

    private void checkName(String input){
        String name = input.trim();
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if(name.length() > 5){
            throw new IllegalArgumentException("Name must be at least 5 characters");
        }
    }

    public void race(){
        for(Car car : cars){
            car.move(Randoms.pickNumberInRange(0,9));
            car.print();
            winStep = Math.max(winStep, car.getStep());
        }
    }

    public void printWinner(){
        List<String> winner = new ArrayList<>();
        for(Car car : cars){
            if(car.getStep() == winStep){
                winner.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }

}
