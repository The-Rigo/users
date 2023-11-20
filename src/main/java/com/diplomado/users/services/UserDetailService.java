package com.diplomado.users.services;

import com.diplomado.users.domain.entities.UserDetail;

import java.util.List;

public interface UserDetailService {
    List<UserDetail> getUserDetailByUser(Integer userId);
    UserDetail save(UserDetail userDetail);
}
