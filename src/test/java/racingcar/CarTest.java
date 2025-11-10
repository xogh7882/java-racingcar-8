package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    void 자동차_이름_가져오기(){
        // Given ( 데이터 준비 )
        Car car = new Car("testCar");

        // When ( 동작 실행 )
        String name = car.getName();

        // Then ( 결과 확인 )
        assertThat(name).isEqualTo("testCar");
    }

    @Test
    void 초기_위치는_0이다(){
        // Given
        Car car = new Car("testCar");

        // When
        int step = car.getStep();

        // Then
        assertThat(step).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_전진(){
        Car car = new Car("testCar");

        car.move(4);

        assertThat(car.getStep()).isEqualTo(1);
    }

    // 파라미터 테스트
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void 숫자가_3이하이면_전진못한다(int number){
        // Given
        Car car = new Car("testCar");

        // When
        car.move(number);

        // Then
        assertThat(car.getStep()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void 숫자가_4이상이면_전진한다(int number){
        // Given
        Car car = new Car("testCar");

        // When
        car.move(number);

        // Then
        assertThat(car.getStep()).isEqualTo(1);
    }

    @Test
    void 전진한_숫자만큼_대시를_출력한다(){
        // Given
        Car car = new Car("testCar");
        car.move(4);
        car.move(5);

        // When
        String status = car.getStatus();

        // Then
        assertThat(status).isEqualTo("testCar : --");
    }

    @Test
    void 전진하지_못하면_출력X(){
        // Given
        Car car = new Car("testCar");
        car.move(1);
        car.move(2);

        // When
        String status = car.getStatus();

        // Then
        assertThat(status).isEqualTo("testCar : ");
    }
}
