package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 제자리_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    assertThat(car.drawPosition()).isEqualTo("pobi : ");
                },
                3
        );
    }

    @Test
    void 전진_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.drawPosition()).isEqualTo("pobi : -");
            },
            4
        );
    }

    @Test
    void 여러번_전진_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    car.move();
                    car.move();
                    car.move();
                    assertThat(car.drawPosition()).isEqualTo("pobi : ---");
                },
                4, 5, 6
        );
    }

    @Test
    void 이름_중복_테스트() {
        assertThat(car.hasName("pobi")).isTrue();
        assertThat(car.hasName("crong")).isFalse();
    }

    @Test
    void 최대_위치_계산_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.getMaxPosition(0)).isEqualTo(1);
                assertThat(car.getMaxPosition(5)).isEqualTo(5);
            },
            4
        );
    }

    @Test
    void 위치_일치_이름_반환_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                car.move();
                assertThat(car.ifPositionThenGetName(1)).isPresent().contains("pobi");
                assertThat(car.ifPositionThenGetName(0)).isEmpty();
            },
            4
        );
    }

}