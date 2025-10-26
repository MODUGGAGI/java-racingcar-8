package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final List<Car> carList;

    public Grid(List<Car> carList) {
        this.carList = carList;
    }

    public String race() {
        StringBuilder result = new StringBuilder();

        for (Car car : carList) {
            car.move();
            result.append(car.drawPosition()).append("\n");
        }

        return result.toString();
    }

    public List<String> findWinnerNames() {
        int maxPosition = findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            car.ifPositionThenGetName(maxPosition).ifPresent(winners::add);
        }

        return winners;
    }

    private int findMaxPosition() {
        int maxPosition = 0;

        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }
}
