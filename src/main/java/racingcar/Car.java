package racingcar;

public class Car {
    private static final int FORWARD_THRESHOLD = 3;
    private final String name;
    private int step = 0;

    public Car(String name){
        this.name = name;
    }

    public void move(int number){
        if(number > FORWARD_THRESHOLD){
            step++;
        }
    }

    public String getStatus(){
        return name + " : " + "-".repeat(step);
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }

}

