package com.diplomado.users.dto;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRolDTO {
    private Integer id;
    private Boolean active;
    private LocalDateTime create_at;

    private User user;
    private Rol rol;

    private String user_name;
    private String first_name;
    private String last_name;
    private String rol_name;
}
