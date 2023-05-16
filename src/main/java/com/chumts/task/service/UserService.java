package com.chumts.task.service;

import org.springframework.stereotype.Service;
import com.chumts.task.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    Optional<User> showUserById(Long id);

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

}
