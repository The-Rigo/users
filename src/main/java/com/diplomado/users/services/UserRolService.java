package com.diplomado.users.services;

import com.diplomado.users.dto.UserRolDTO;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    List<UserRolDTO> getAllUserRol(Long user_id);
    Optional<UserRolDTO> getUserRolById(Integer id);
    UserRolDTO save(UserRolDTO rolDTO);
    List<UserRolDTO> getUserRol(Integer rol_id);
    void delete(Integer id);

}
