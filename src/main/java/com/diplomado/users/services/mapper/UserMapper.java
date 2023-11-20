package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.User;
import com.diplomado.users.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User>{

    @Override
    public UserDTO toDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return null;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }
}
