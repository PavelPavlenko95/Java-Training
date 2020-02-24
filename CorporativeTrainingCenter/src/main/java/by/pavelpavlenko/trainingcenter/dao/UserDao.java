package by.pavelpavlenko.trainingcenter.dao;

import by.pavelpavlenko.trainingcenter.entity.User;
import by.pavelpavlenko.trainingcenter.exception.DaoException;

public interface UserDao extends BaseDao<User> {

    void registerLecturer(User user) throws DaoException;

    void registerEmployee(User user) throws DaoException;

    User login(String login, String password) throws DaoException;

    boolean userExists(String login) throws DaoException;

    User findEmployeeByLogin(String login) throws DaoException;

    User findLecturerByLogin(String login) throws DaoException;

    User updateUserPassword(User user, String newPassword) throws DaoException;

    boolean userMatches(String login, String password) throws DaoException;
}