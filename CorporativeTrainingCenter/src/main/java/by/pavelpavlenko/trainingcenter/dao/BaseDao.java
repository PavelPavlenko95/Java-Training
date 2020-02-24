package by.pavelpavlenko.trainingcenter.dao;

import by.pavelpavlenko.trainingcenter.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;

public interface BaseDao<T extends Entity> {

    Logger logger = LogManager.getLogger(BaseDao.class);

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error("Couldn't close statement: ", e);
        }
    }
}

