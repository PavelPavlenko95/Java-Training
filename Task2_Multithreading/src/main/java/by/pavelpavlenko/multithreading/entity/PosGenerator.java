package by.pavelpavlenko.multithreading.entity;

public class PosGenerator {

    private int currentPos = 0;

    public int getNext() {
        return currentPos++;
    }

}
