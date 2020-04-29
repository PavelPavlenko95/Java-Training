package com.pavelpavlenko.iba.iba_project_sql.service;

import java.util.List;

import com.pavelpavlenko.iba.iba_project_sql.model.User;
import com.pavelpavlenko.iba.iba_project_sql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository urep;

    @Override
    public List<User> getUsers() {
        return urep.findAll();
    }

    @Override
    public User getUser(int id) {
        return urep.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        return urep.save(user);
    }

    @Override
    public void deleteUser(int id) {
        urep.deleteById(id);
    }

}
