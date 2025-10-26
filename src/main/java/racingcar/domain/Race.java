package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Grid grid;
    private final int racingRounds;

    public Race(ArrayList<Car> carList, int racingRounds) {
        this.grid = new Grid(carList);
        this.racingRounds = racingRounds;
    }

    public String startRacing() {
        StringBuilder raceLog = new StringBuilder();

        for (int i = 0; i < racingRounds; i++) {
            raceLog.append(grid.race()).append("\n");
        }

        return raceLog.toString();
    }

    public List<String> findWinners() {
        return grid.findWinnerNames();
    }
}
