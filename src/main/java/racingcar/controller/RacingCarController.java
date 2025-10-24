package racingcar.controller;

import racingcar.domain.Race;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView view = new RacingCarView();
    private final RacingCarService service = new RacingCarService();

    public void startRacing() {
        String carNames = view.getCarNames();
        String racingRounds = view.getRacingRounds();

        Race race = service.createRace(carNames, racingRounds);

        view.printRaceLog(race.startRacing());
        view.printWinners(race.findWinners());
    }
}
