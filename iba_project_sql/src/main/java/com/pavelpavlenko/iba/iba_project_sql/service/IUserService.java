package com.pavelpavlenko.iba.iba_project_sql.service;

import com.pavelpavlenko.iba.iba_project_sql.model.User;

import java.util.List;

public interface IUserService {

    public List<User> getUsers();

    public User getUser(int id);

    public User addUser(User user);

    public void deleteUser(int id);
}

