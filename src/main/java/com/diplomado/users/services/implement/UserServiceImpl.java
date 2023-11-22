package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.User;
import com.diplomado.users.domain.entities.UserDetail;
import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.UserDTO;
import com.diplomado.users.repositories.UserDetailRepository;
import com.diplomado.users.repositories.UserRepository;
import com.diplomado.users.repositories.UserRolRepository;
import com.diplomado.users.services.UserService;
import com.diplomado.users.services.mapper.UserMapper;
import com.diplomado.users.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailRepository userDetailRepository;
    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, UserDetailRepository userDetailRepository, UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailRepository = userDetailRepository;
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsersDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDtoDetail)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = userRepository.save(userMapper.toEntity(dto));
        userDetailRepository.save(new UserDetail(dto.getFirst_name(), dto.getLast_name(), dto.getAge(), null,user));
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDTO edit(Long id, UserDTO user) {
        user.setId(id);
        return this.userMapper.toDto(userRepository.save(this.userMapper.toEntity(user)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUsersById(Long id) {
        return userRepository.findById(id).map(userMapper::toDtoDetail);
    }
}
