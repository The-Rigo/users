package com.diplomado.users.dto;

import com.diplomado.users.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetailedDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDay;
    private User user;
}
