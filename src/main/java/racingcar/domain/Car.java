package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Optional;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public String drawPosition() {
        return name + " : " + "-".repeat(position);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public int getMaxPosition(int position) {
        return Math.max(this.position, position);
    }

    public Optional<String> ifPositionThenGetName(int position) {
        if (this.position == position) {
            return Optional.of(name);
        }
        return Optional.empty();
    }
}
