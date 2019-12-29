package by.pavelpavlenko.classesandobjects.dao;

import by.pavelpavlenko.classesandobjects.model.Abonent;

import java.io.IOException;

public interface AbonentDaoEditor extends ItemDao<Abonent>{

    public void addNewAbonent() throws IOException;

    public void deleteAbonentById();

}
