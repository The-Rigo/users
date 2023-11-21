package com.diplomado.users.dto;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRolDTO {
    private Integer id;
    private Boolean active;

    private Rol rolId;
    private User userId;

    private String firstName;
    private String lastName;
    private String rolName;
}
