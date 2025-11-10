package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Cars {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final List<Car> cars;
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
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("Name must be at most 5 characters");
        }
    }

    public void race(OutputContent outputContent){
        for(Car car : cars){
            car.move(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER,MAX_RANDOM_NUMBER));
            outputContent.printCarStatus(car);
            winStep = Math.max(winStep, car.getStep());
        }
    }

    public List<String> getWinner(){
        List<String> winner = new ArrayList<>();
        for(Car car : cars){
            if(car.getStep() == winStep){
                winner.add(car.getName());
            }
        }
        return winner;
    }

}
