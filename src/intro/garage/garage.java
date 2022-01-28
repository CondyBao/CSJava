package intro.garage;

public class garage {
    private car[] cars;

    public void addCar(String name, int year, int mileage, int i) {
        if (i >= cars.length || i < 0) {
            System.out.println("invalid index");
            return;
        }
        cars[i] = new car(name, year, mileage);
    }

    public int totalWorth() {
        int total = 0;
        for (intro.garage.car car : cars) {
            if (car == null) continue;
            total += car.worth();
        }
        return total;
    }

    public double averageMileage() {
        int total = 0, carCnt = 0;
        for (intro.garage.car car : cars) {
            if (car == null) continue;
            total += car.getMileage();
            carCnt++;
        }
        return 1.0 * total / carCnt;
    }

    public void drive(int i, int n) {
        if (i >= cars.length || i < 0 || cars[i] == null) {
            System.out.println("invalid index");
            return;
        }
        cars[i].drive(n);
    }

    public garage (int n) {
        cars = new car[n];
    }

    public static void main(String[] args) {
        garage newGarage = new garage(5);
        newGarage.addCar("oldCar", 1999, 200000, 0);
        newGarage.addCar("invalidCar", 1029, 0, -1);
        newGarage.addCar("newCar", 2022, 50, 2);
        newGarage.addCar("replaceOldCar", 1998, 300000, 0);
        newGarage.addCar("bestCar", 2022, 0, 3);
        newGarage.addCar("weirdCar", 2015, 12345, 4);
        newGarage.drive(2, 5000);
        System.out.println(newGarage.totalWorth());
        System.out.println(newGarage.averageMileage());
    }
}
