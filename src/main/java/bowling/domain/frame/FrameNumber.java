package bowling.domain.frame;

import java.util.Objects;

public class FrameNumber {
    public static final int MIN = 1;
    public static final int MAX = 10;
    static final int MAX_IN_NORMAL_FRAME = 9;

    private final int number;

    public FrameNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN) {
            throw new IllegalArgumentException(String.format("FrameNumber(%s)는 최솟값(%s) 미만 일 수 없습니다.", number, MIN));
        }
        if (number > MAX) {
            throw new IllegalArgumentException(String.format("FrameNumber(%s)는 최댓값(%s) 초과 일 수 없습니다.", number, MAX));
        }
    }

    public static FrameNumber min() {
        return new FrameNumber(MIN);
    }

    public FrameNumber next() {
        return new FrameNumber(number + 1);
    }

    public boolean isNormal() {
        return number <= MAX_IN_NORMAL_FRAME;
    }

    public boolean isMaxInNormal() {
        return number == MAX_IN_NORMAL_FRAME;
    }

    public boolean isBigger(FrameNumber frameNumber) {
        return number > frameNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
