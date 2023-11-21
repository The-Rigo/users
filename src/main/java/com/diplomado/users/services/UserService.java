package com.diplomado.users.services;


import com.diplomado.users.domain.entities.User;
import com.diplomado.users.dto.UserDTO;


import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> listUsers();
    UserDTO save(UserDTO dto);
    void deleteUser(Long userId);
}
