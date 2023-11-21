package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.User;
import com.diplomado.users.dto.UserDTO;
import com.diplomado.users.repositories.UserRepository;
import com.diplomado.users.services.UserService;
import com.diplomado.users.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        return this.userMapper.toDto(userRepository.save(this.userMapper.toEntity(dto)));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }



    /*@Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }*/
}
