package by.pavelpavlenko.classesandobjects.dao;

import by.pavelpavlenko.classesandobjects.model.Abonent;

public interface AbonentDaoSelector extends ItemDao<Abonent>{

    public Abonent getAbonentsByAplhabet();

    public Abonent getAbonentsByFirstNumber();
}
