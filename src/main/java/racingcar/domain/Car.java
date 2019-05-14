package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private static void validateName(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 검증 실패");
        }
    }

    public void run(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Car) obj).name.equals(this.name) && ((Car) obj).position == this.position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + position;
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}