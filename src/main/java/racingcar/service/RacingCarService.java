package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class RacingCarService {

    public Race createRace(String carNames, String inputRounds) {
        String[] spiltCarNames = carNames.split(",");

        ArrayList<Car> carList = new ArrayList<>();

        for (String carName : spiltCarNames) {
            validateCarName(carName, carList);
            carList.add(new Car(carName));
        }

        int racingRounds = validateRacingRounds(inputRounds);
        return new Race(carList, racingRounds);
    }

    private int validateRacingRounds(String inputRounds) {
        try {
            return checkPositive(inputRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수만 가능합니다.");
        }
    }

    private int checkPositive(String inputRounds) {
        int racingRounds = Integer.parseInt(inputRounds);

        if (racingRounds < 0) {
            throw new IllegalArgumentException("시도 횟수는 양수만 가능합니다.");
        }

        return racingRounds;
    }


    private void validateCarName(String carName, List<Car> carList) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }

        if (carList.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
