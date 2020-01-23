package by.pavelpavlenko.classesandobjects.view;

import by.pavelpavlenko.classesandobjects.model.Abonent;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DataScanner {

    private Scanner in = new Scanner(System.in);

    public Abonent scanAbonentInfo() {

        Abonent abonent = new Abonent();
        try {
            System.out.println("Введите имя:");
            abonent.setName(in.next());
            System.out.println("Введите фамилию:");
            abonent.setLastName(in.next());
            System.out.println("Введите Отчество:");
            abonent.setPatronymic(in.next());
            System.out.println("Введите адрес:");
            abonent.setAddress(in.next());
        } catch (InputMismatchException e) {
            System.out.println("Данные введены некорректно!");
        }
return abonent;

    }

    public int scanActionNumber() {
        int result = 0;
        System.out.println("1 - добавить нового абонента. 2- вывести список абонентов - Для выхода - любое другое значение):");
        try {
            do {
                switch (in.nextInt()) {
                    case 1:
                        result = 1;
                        break;
                    case 2:
                        result = 2;
                        break;
                    case 3:
                        result = 3;
                        break;
                    case 4:
                        result = 4;
                        break;

                    default:
                        break;
                }
            } while (result == 0);
        } catch (InputMismatchException e) {
        }
        return result;
    }
}
