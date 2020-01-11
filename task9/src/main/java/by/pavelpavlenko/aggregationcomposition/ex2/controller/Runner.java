package by.pavelpavlenko.aggregationcomposition.ex2.controller;

import by.pavelpavlenko.aggregationcomposition.ex2.model.Car;
import by.pavelpavlenko.aggregationcomposition.ex2.model.Wheel;
import by.pavelpavlenko.aggregationcomposition.ex2.view.PrintReader;


public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        String wheelType;

        switch (printReader.inputWheelType()) {
            case 1: wheelType = "Зимняя резина"; break;
            case 2: wheelType = "Летняя резина"; break;
            default: wheelType = "Летняя резина";
        }
        Wheel wheel = new Wheel(wheelType);

        Car car = new Car(wheel, printReader.inputCarModel());
        int choice = -1;

        while (choice != 0) {
            choice = printReader.inputChoice();

            switch (choice) {
                case 1: car.move(); break;
                case 2: car.refuel(); break;
                case 3: Wheel newWheel = new Wheel(printReader.inputWheelType() == 1 ? "Зимняя резина" : "Летняя резина");
                    car.changeWheel(newWheel); break;
                case 4: car.printInfo(); break;
            }
        }

    }

}
