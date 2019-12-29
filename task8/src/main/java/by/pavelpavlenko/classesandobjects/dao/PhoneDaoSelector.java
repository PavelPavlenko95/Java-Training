package by.pavelpavlenko.classesandobjects.dao;

import by.pavelpavlenko.classesandobjects.model.Phone;

public interface PhoneDaoSelector extends ItemDao<Phone>{

    public Phone getNumberOverflow();

    public Phone getNumberLongDistance();

}
