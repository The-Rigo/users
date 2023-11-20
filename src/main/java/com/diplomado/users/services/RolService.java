package com.diplomado.users.services;

import com.diplomado.users.domain.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> getAllRoles();
    Optional<Rol> getRolById(Integer id);
    Rol createOrUpdateRol(Rol rol);
    void deleteRolById(Integer id);
}
