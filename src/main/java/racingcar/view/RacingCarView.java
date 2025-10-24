package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarView {

    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_ROUNDS_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RACE_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public String getCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String getRacingRounds() {
        System.out.println(RACE_ROUNDS_MESSAGE);
        return Console.readLine();
    }

    public void printRaceLog(String raceLog) {
        System.out.println(RACE_RESULT_MESSAGE);
        System.out.print(raceLog);
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE + String.join(", ", winners));
    }
}
