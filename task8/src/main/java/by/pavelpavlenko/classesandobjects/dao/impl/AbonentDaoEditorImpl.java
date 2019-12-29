package by.pavelpavlenko.classesandobjects.dao.impl;

import by.pavelpavlenko.classesandobjects.dao.AbonentDaoEditor;
import by.pavelpavlenko.classesandobjects.model.Abonent;
import by.pavelpavlenko.classesandobjects.view.DataScanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoEditorImpl implements AbonentDaoEditor {


    public void addNewAbonent() throws IOException {

        DataScanner dataScanner = new DataScanner();
        FileWriter writer = new FileWriter("D:\\abonents.txt");
        Abonent abonent = dataScanner.scanAbonentInfo();
        writer.write(abonent.getLastName() + " ");
        writer.write(abonent.getName()+ " ");
        writer.write(abonent.getPatronymic()+ " ");
        writer.write(abonent.getAddress()+ " ");
        writer.close();
    }

    public void deleteAbonentById() {

    }

    public Abonent getById(int id) {
        return null;
    }

    public List<Abonent> getAll() {
        return null;
    }
}
