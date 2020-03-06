package by.pavelpavlenko.multithreading.controller;

import by.pavelpavlenko.multithreading.entity.Matrix;
import by.pavelpavlenko.multithreading.service.MatrixService;
import by.pavelpavlenko.multithreading.service.impl.MatrixServiceImpl;
import by.pavelpavlenko.multithreading.dao.impl.MatrixWriterImpl;
import by.pavelpavlenko.multithreading.view.PrinterInfo;

import java.util.Scanner;

public final class MainController {

    private MainController() {
    }

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        MatrixService matrixService = null;
        PrinterInfo info = new PrinterInfo();
        boolean flag = true;

        info.printInfo();

        while (flag) {

            String str = scanner.next();

            switch (str) {
                case "1":
                    matrixService = new MatrixServiceImpl();
                    matrixService.readMatrix("src\\main\\resources\\input.txt");
                    break;

                case "2":
                    if (matrixService != null) {
                        matrixService.fillMatrixLocker();
                    } else {
                        System.out.println("The matrix is not initialized");
                    }
                    break;

                case "3":
                    if (matrixService != null) {
                        matrixService.fillMatrixCountDown();
                    } else {
                        System.out.println("The matrix is not initialized");
                    }
                    break;

                case "4":
                    if (matrixService != null) {
                        matrixService.fillMatrixCyclicBarrier();
                    } else {
                        System.out.println("The matrix is not initialized");
                    }
                    break;

                case "5":
                    if (matrixService != null) {
                        matrixService.fillMatrixSemaphore();
                    } else {
                        System.out.println("The matrix is not initialized");
                    }
                    break;

                case "6":
                    if (!matrixService.showMatrix()) {
                        System.out.println("The matrix not exist yet");
                    }
                    break;

                case "7":
                    new MatrixWriterImpl().write("src\\main\\resources\\output.txt", Matrix.getInstance());
                    break;

                case "8":
                    flag = false;
                    break;

                default:
                    System.out.println("Error of input");
                    break;
            }

        }
        scanner.close();

    }
}