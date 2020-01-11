package by.pavelpavlenko.aggregationcomposition.ex2.model;
import by.pavelpavlenko.aggregationcomposition.ex2.view.PrintReader;

class Engine {
    private String type;
    private boolean isWorking = false;

    Engine(String type) {
        this.type = type;
    }

    Engine() {
        type = "Бензиновый";
    }

    void work() {
        PrintReader.printMessage("Двигатель работает.");
        isWorking = true;
    }

    void stopWork() {
        if (isWorking) {
            PrintReader.printMessage("Двигатель перестал работать.");
            isWorking = false;
        } else {
            PrintReader.printMessage("Двигатель не работает");
        }
    }

    String getType() {
        return type;
    }
}

