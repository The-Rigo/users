package com.diplomado.users.services;

import com.diplomado.users.domain.entities.UserRol;

import java.util.List;

public interface UserRolService {
    List<UserRol> listUserRol();
    UserRol save(UserRol userRol);
}
