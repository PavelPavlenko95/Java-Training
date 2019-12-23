package by.pavelpavlenko.massives.Model;

public class Methods {

    boolean isElementsIncreasing(double[] mas) {
        boolean result = true;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] >= mas[i + 1]) result = false;
        }
        return result;
    }

    int maxElement(double[] array) {
        double max = Integer.MIN_VALUE;
        int maxPosition = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }

    int minElement(double[] array) {
        double min = Integer.MAX_VALUE;
        int minPosition = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minPosition = i;
            }
        }
        return minPosition;
    }

    void swapElements(double[] array, int maxPosition, int minPosition) {
        double temp = array[maxPosition];
        array[maxPosition] = array[minPosition];
        array[minPosition] = temp;
    }

    double maxEven(double[] mas) {
        double maxValue = Double.MIN_VALUE;
        for (int i = 1; i < mas.length; i += 2) {
            if (mas[i] > maxValue) {
                maxValue = mas[i];
            }
        }
        return maxValue;
    }

    double minOdd(double[] mas) {
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < mas.length; i += 2) {
            if (mas[i] < minValue) {
                minValue = mas[i];
            }
        }
        return minValue;
    }

    public int findTheMostFrequentNumber(int[] data) {
        int[] popular = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i] == data[j]) {
                    popular[i]++;
                }
            }
        }
        int valResult = data[0];
        int popResult = popular[0];
        for (int i = 0; i < popular.length; i++) {
            if (popular[i] > popResult) {
                popResult = popular[i];
                valResult = data[i];
            }
            if ((popResult == popular[i]) && (data[i] < valResult)) {
                valResult = data[i];
            }
        }
        return valResult;
    }
}
