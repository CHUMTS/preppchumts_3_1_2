package com.chumts.task.dao;

import com.chumts.task.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {

}
