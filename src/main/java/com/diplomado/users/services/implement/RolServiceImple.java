package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.repositories.RolRepository;
import com.diplomado.users.services.RolService;
import com.diplomado.users.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImple implements RolService {
    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImple(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }
    //Read all
    @Override
    public List<RolDTO> getAllRoles() {
        return rolRepository.findAll().stream().map(rolMapper::toDto).collect(Collectors.toList());
    }
    //read one rol
    @Override
    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }

    //Create o update
    @Override
    public RolDTO save(RolDTO rolDTO) {
        return this.rolMapper.toDto(rolRepository.save(this.rolMapper.toEntity(rolDTO)));
    }

    @Override
    public RolDTO edit(Integer id, RolDTO rolDTO) {
        rolDTO.setId(id);
        return this.rolMapper.toDto(rolRepository.save(this.rolMapper.toEntity(rolDTO)));
    }

    //Delete
    @Override
    public void deleteRolById(Integer id) {
        rolRepository.deleteById(id);
    }
}
