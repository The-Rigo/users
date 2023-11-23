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
        userDTO.setCreated_at(user.getCreated_at());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user =new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setCreated_at(userDTO.getCreated_at());
        return user;
    }

    public UserDTO toDtoDetail(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreated_at(user.getCreated_at());
        if (user.getUserDetail()!=null){
            dto.setFirst_name(user.getUserDetail().getFirst_name());
            dto.setLast_name(user.getUserDetail().getLast_name());
            dto.setAge(user.getUserDetail().getAge());
            dto.setBirth_day(user.getUserDetail().getBirth_day());
        }else{
            dto.setFirst_name(null);
            dto.setLast_name(null);
            dto.setAge(null);
            dto.setBirth_day(null);
        }
        return dto;
    }
}
