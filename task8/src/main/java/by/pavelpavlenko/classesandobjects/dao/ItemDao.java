package by.pavelpavlenko.classesandobjects.dao;

import by.pavelpavlenko.classesandobjects.model.Model;

import java.util.List;

public interface ItemDao<T extends Model >{

    public T getById(int id);

    public List<T> getAll();

}
