package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.repositories.UserRolRepository;
import com.diplomado.users.services.UserRolService;
import com.diplomado.users.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {
    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;


    public UserRolServiceImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }


    @Override
    public List<UserRolDTO> getAllUserRol(Long user_id) {
        return userRolRepository.findAllByUserId(user_id)
                .stream()
                .map(userRolMapper::toDtoList).collect(Collectors.toList());
    }



    @Override
    public Optional<UserRolDTO> getUserRolById(Integer id) {
        return userRolRepository.findById(id).map(userRolMapper::toDto);
    }

    @Override
    public UserRolDTO save(UserRolDTO rolDTO) {
        UserRol userRol = userRolRepository.save(userRolMapper.toEntity(rolDTO));
        return userRolMapper.toDto(userRol);
    }

    @Override
    public List<UserRolDTO> getUserRol(Integer rol_id) {
        return userRolRepository.findAllByRolId(rol_id)
                .stream()
                .map(userRolMapper::toDtoList).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        userRolRepository.deleteById(id);
    }
}
