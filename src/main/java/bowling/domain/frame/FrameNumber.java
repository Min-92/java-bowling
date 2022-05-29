package bowling.domain.frame;

public class FrameNumber {
    static final int MIN = 1;
    static final int MAX = 10;
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

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
