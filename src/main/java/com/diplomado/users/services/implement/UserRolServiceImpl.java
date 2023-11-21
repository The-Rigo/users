package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.repositories.UserRolRepository;
import com.diplomado.users.services.UserRolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;

    public UserRolServiceImpl(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRol> listUserRol() {
        return null;
    }

    @Override
    public UserRol save(UserRol userRol) {
        return null;
    }
}
