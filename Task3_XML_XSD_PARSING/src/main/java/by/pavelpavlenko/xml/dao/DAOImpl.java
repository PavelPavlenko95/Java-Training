package by.pavelpavlenko.xml.dao;

import java.io.File;

public class DAOImpl implements DAO {

    public File getFile(final String name) {
        return new File(name);
    }

}
