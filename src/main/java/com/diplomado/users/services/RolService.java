package com.diplomado.users.services;

import com.diplomado.users.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> getAllRoles();//ok
    Optional<RolDTO> getRolById(Integer id);//ok
    RolDTO save(RolDTO rolDTO);
    RolDTO edit(Integer id,RolDTO rol);
    void deleteRolById(Integer id);
}
