package racingcar;

import java.util.List;

public class Car {
    private String name;
    private int step = 0;

    public Car(String name){
        checkName(name);
        this.name = name;
    }

    private void checkName(String name){
        if(name.isEmpty() || name.length() > 5){
            throw new IllegalArgumentException("Car name can't longer than 5 characters");
        }
    }

    public void move(Integer number){
        if(number > 3){
            step++;
        }
    }

    public void print(){
        System.out.print(name + " : ");
        for(int i = 0; i < step; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void winner(int winStep){
        if(step == winStep){
            System.out.print(name+", ");
        }
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int winStep){
        return this.step == winStep;
    }
}

