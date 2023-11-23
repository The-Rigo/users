package com.diplomado.users.services;

import com.diplomado.users.dto.UserDTO;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> listUsers();
    List<UserDTO>listUsersDetailed();
    UserDTO save(UserDTO dto);
    void deleteUser(Long userId);

    UserDTO edit(Long id, UserDTO user);
    Optional<UserDTO> getUsersById(Long id);
}
