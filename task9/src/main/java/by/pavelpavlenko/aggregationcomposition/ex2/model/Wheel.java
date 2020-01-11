package by.pavelpavlenko.aggregationcomposition.ex2.model;

import by.pavelpavlenko.aggregationcomposition.ex2.view.PrintReader;

public class Wheel {
    private String type;
    private boolean isRotating = false;

    public Wheel(String type) {
        this.type = type;
    }

    Wheel() {
        type = "Летнее";
    }

    void rotate() {
        PrintReader.printMessage("Колесо вращается.");
        isRotating = true;
    }

    void stopRotate() {
        if (isRotating) {
            PrintReader.printMessage("Колесо остановило вращение.");
            isRotating = false;
        } else {
            PrintReader.printMessage("Колесо не вращается.");
        }
    }

    String getType() {
        return type;
    }
}
