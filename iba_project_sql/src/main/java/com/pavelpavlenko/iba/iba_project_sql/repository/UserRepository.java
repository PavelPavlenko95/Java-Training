package com.pavelpavlenko.iba.iba_project_sql.repository;

import com.pavelpavlenko.iba.iba_project_sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}