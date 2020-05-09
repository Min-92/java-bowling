package bowling;

import bowling.domain.Pins;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PinsTest {
    @Test
    @DisplayName("첫번째 시도에 핀이 10개 쓰러지면 스트라이크 처리한다")
    public void firstBowlFallenPinsTenIsStrike() {
        Pins pins = new Pins();
        pins.bowl(10);

        assertThat(pins.isStrike()).isTrue();
    }

    @Test
    @DisplayName("프레임 종료 후 쓰러진 핀이 10개면 스페어 처리한다")
    public void sumOfFallenPinsTenIsSpare() {
        Pins pins = new Pins();
        pins.bowl(9);
        pins.bowl(1);

        assertThat(pins.isSpare()).isTrue();
    }

    @Test
    @DisplayName("프레임 종류 후 쓰러진 핀이 10개 미만이면 미스 처리한다")
    public void sumOfFallenPinsUnderTenIsMiss() {
        Pins pins = new Pins();
        pins.bowl(6);
        pins.bowl(2);

        assertThat(pins.isMiss()).isTrue();
    }

    @Test
    @DisplayName("2번의 시도가 끝나면 프레임이 종료된다")
    public void tryBowlingTwiceIsFinish() {
        Pins pins = new Pins();
        pins.bowl(6);
        pins.bowl(2);

        assertThat(pins.isFinish()).isTrue();
    }

    @Test
    @DisplayName("보드에 기록될 프레임 결과 표시를 얻는다")
    public void getDescriptionForRecordOnBoard() {
        Pins pins = new Pins();
        pins.bowl(10);

        assertThat(pins.getDescription()).isEqualTo("X");

        Pins pins2 = new Pins();
        pins2.bowl(8);
        pins2.bowl(2);

        assertThat(pins2.getDescription()).isEqualTo("8|/");

        Pins pins3 = new Pins();
        pins3.bowl(0);

        assertThat(pins3.getDescription()).isEqualTo("-");
    }
}