package singleton.implement;

public class CarFactory {
    private static CarFactory instance;
    private static int id = 10000;
    private CarFactory() {}
    public static CarFactory getInstance() {
        if (instance == null) {
            instance = new CarFactory();
        }
        return instance;
    }

    public Car createCar() {
        return new Car(++id);
    }
}
