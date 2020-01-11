package by.pavelpavlenko.aggregationcomposition.ex2.model;
import by.pavelpavlenko.aggregationcomposition.ex2.view.PrintReader;


public class Car {
    private Engine engine;
    private Wheel wheel;
    private String model;

    public Car(Wheel wheel, String model) {
        String engineType;

        switch (PrintReader.inputEngineType()) {
            case 1: engineType = "Бензиновый"; break;
            case 2: engineType = "Дизельный"; break;
            case 3: engineType = "Газовый"; break;
            default: engineType = "Газовый";
        }

        engine = new Engine(engineType);

        this.wheel = wheel;
        this.model = model;
    }

    public Car() {
        engine = new Engine();
        wheel = new Wheel();
        model = "";
    }

    public void printInfo() {
        PrintReader.printMessage("Модель - " + model);
        PrintReader.printMessage("Двигатель - " + engine.getType());
        PrintReader.printMessage("Колесо - " + wheel.getType());
    }

    public void move() {
        engine.work();
        wheel.rotate();
        PrintReader.printMessage("Автомобиль едет.");
    }

    public void refuel() {
        engine.stopWork();
        wheel.stopRotate();
        PrintReader.printMessage("Автомобиль остановился для заправки.");
    }

    public void changeWheel(Wheel wheel) {
        PrintReader.printMessage("Колесо меняется с типа " + this.wheel.getType() + "на тип " + wheel.getType());
        this.wheel = wheel;
    }
}