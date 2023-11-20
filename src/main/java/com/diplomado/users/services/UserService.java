package com.diplomado.users.services;

import com.diplomado.users.domain.entities.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User save(User user);

}
