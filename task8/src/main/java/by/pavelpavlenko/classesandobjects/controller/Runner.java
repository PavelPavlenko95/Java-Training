package by.pavelpavlenko.classesandobjects.controller;

import by.pavelpavlenko.classesandobjects.dao.ItemDao;
import by.pavelpavlenko.classesandobjects.dao.impl.AbonentDaoEditorImpl;
import by.pavelpavlenko.classesandobjects.view.DataScanner;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {

//считываем информацию из файла
        //создаем коллекцию объектов
        //шаблон репрозиторий
        //больница в ней коллекция пациентов
        //валидатор опционально
        //телефон начинается на какую-то цифру
        //всё реальизуем в репрозитории
        //коллекцию не передаем, делаем копию (по возможности)
        ItemDao itemDao = new AbonentDaoEditorImpl();

        DataScanner dataScanner = new DataScanner();
        boolean exit = false;
        do {
            switch (dataScanner.scanActionNumber()) {
                case 1:
                    ((AbonentDaoEditorImpl) itemDao).addNewAbonent();
                    break;
                case 2:
                    ((AbonentDaoEditorImpl) itemDao).getAll();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    exit = true;
                    break;

            }
        } while (!exit);
    }


}
