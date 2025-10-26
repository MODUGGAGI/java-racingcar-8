package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private ArrayList<Car> carList;
    private int racingRounds;

    public Race(ArrayList<Car> carList, int racingRounds) {
        this.carList = carList;
        this.racingRounds = racingRounds;
    }

    public String startRacing() {

        StringBuilder raceLog = new StringBuilder();

        for (int i = 0; i < racingRounds; i++) {
            playEachRound(raceLog);
        }

        return raceLog.toString();
    }

    public List<String> findWinners() {

        int maxPosition = findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            car.ifPositionThenGetName(maxPosition).ifPresent(winners::add);
        }

        return winners;
    }

    private void playEachRound(StringBuilder raceLog) {
        for (Car car : carList) {
            car.move();
            raceLog.append(car.drawPosition()).append("\n");
        }
        raceLog.append("\n");
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }
}
