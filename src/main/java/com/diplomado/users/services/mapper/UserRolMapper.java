package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreate_at(userRol.getCreated_id());
        dto.setUser(userRol.getUser());
        dto.setRol(userRol.getRol());

        return dto;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol = new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.getActive());
        userRol.setCreated_id(userRolDTO.getCreate_at());
        userRol.setUser(userRolDTO.getUser());
        userRol.setRol(userRolDTO.getRol());
        return userRol;
    }

    public UserRolDTO toDtoList(UserRol userRol){
        UserRolDTO dto= new UserRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreate_at(userRol.getCreated_id());
        if (userRol.getUser()!= null && userRol.getRol() !=null){
            dto.setUser(userRol.getUser());
            dto.setRol(userRol.getRol());
            dto.setUser_name(userRol.getUser().getUsername());
            dto.setFirst_name(userRol.getUser().getUserDetail().getFirst_name());
            dto.setLast_name(userRol.getUser().getUserDetail().getLast_name());
            dto.setRol_name(userRol.getRol().getName());
        }else{
            dto.setUser(null);
            dto.setRol(null);
        }
        return dto;
    }
}
