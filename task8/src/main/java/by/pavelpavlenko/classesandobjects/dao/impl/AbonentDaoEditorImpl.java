package by.pavelpavlenko.classesandobjects.dao.impl;

import by.pavelpavlenko.classesandobjects.dao.AbonentDaoEditor;
import by.pavelpavlenko.classesandobjects.model.Abonent;
import by.pavelpavlenko.classesandobjects.view.DataScanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AbonentDaoEditorImpl implements AbonentDaoEditor {

    private DataScanner dataScanner = new DataScanner();


    public AbonentDaoEditorImpl() throws IOException {
    }


    public void addNewAbonent() throws IOException {
        FileReader reader =  new FileReader("src/main/resources/abonents.txt");
        Scanner scanner = new Scanner(reader);
        int id = 0;
        while (scanner.hasNextLine()){
            id++;
            scanner.nextLine();
        }
        reader.close();
        FileWriter writer = new FileWriter("src/main/resources/abonents.txt" , true);
        Abonent abonent = dataScanner.scanAbonentInfo();

        writer.write("\n" + id + 1 + " ");
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
