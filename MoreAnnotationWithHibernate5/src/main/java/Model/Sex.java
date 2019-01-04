package Model;

public enum Sex {
    MALE,
    FEMALE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
