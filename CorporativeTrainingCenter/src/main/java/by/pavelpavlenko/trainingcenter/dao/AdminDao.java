package by.pavelpavlenko.trainingcenter.dao;

import by.pavelpavlenko.trainingcenter.entity.User;
import by.pavelpavlenko.trainingcenter.exception.DaoException;

import java.util.List;

public interface AdminDao extends BaseDao<User> {

    List<User> selectUserList() throws DaoException;

    User selectCurrentUser(int userId) throws DaoException;

    void updateUserLogin(int userId, String currentLogin) throws DaoException;

    void updateUserRole(int userId, int roleId) throws DaoException;

    void resetUserInfo(int userId) throws DaoException;
}

