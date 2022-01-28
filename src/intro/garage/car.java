package intro.garage;

public class car {
    private String name;

    private int year, mileage;

    public String getName() {
        return name;
    }

    public int worth() {
        return 1000000 - (3000 - year) * 15 - mileage * 2;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public void drive(int distance) {
        mileage += distance;
    }

    public car(String name, int year, int mileage) {
        this.name = name;
        this.year = year;
        this.mileage = mileage;
    }
}
