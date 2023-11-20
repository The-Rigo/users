package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.UserDetail;
import com.diplomado.users.repositories.UserDetailRepository;
import com.diplomado.users.services.UserDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserDetailImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    public UserDetailImpl(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public List<UserDetail> getUserDetailByUser(Long userId) {
        return userDetailRepository.findAll().stream()
                .filter(userDetail -> Objects.equals(userDetail.getUser().getId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetail save(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }
}
