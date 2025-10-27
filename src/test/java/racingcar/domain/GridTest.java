package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class GridTest {

    private Grid grid;

    @BeforeEach
    void setUp() {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("woni"));
        carList.add(new Car("jun"));

        grid = new Grid(carList);
    }

    @Test
    @DisplayName("레이스 1회 실행한 경우")
    void 레이스_결과_출력_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                String result = grid.race();
                assertThat(result).contains("pobi : -", "woni : ", "jun : -");
            },
            4, 3, 5
        );
    }

    @Test
    @DisplayName("우승자가 1명인 경우")
    void 우승자_한명_찾기_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                grid.race();
                List<String> winners = grid.findWinnerNames();
                assertThat(winners).containsExactly("jun");
            },
            3, 3, 6
        );
    }

    @Test
    @DisplayName("공동 우승자가 있는 경우")
    void 우승자_여러명_찾기_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                grid.race();
                List<String> winners = grid.findWinnerNames();
                assertThat(winners).containsExactlyInAnyOrder("pobi", "jun");
            },
            5, 3, 5
        );
    }

}