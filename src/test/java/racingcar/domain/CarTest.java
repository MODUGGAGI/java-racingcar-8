package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("랜덤 값이 4 미만인 경우 제자리")
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
    @DisplayName("랜덤 값이 4 이상인 경우 전진")
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
    @DisplayName("4 이상인 랜덤값이 여러번일 경우 여러번 전진")
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
    @DisplayName("자동차의 이름이 이미 사용 중인 경우")
    void 이름_중복_테스트() {
        assertThat(car.hasName("pobi")).isTrue();
        assertThat(car.hasName("crong")).isFalse();
    }

    @Test
    @DisplayName("특정 위치가 주어진 경우 자신의 위치와 비교 후 최댓값 반환")
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
    @DisplayName("동일한 위치에 있을 경우 이름을 반환")
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