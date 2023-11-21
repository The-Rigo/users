package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.repositories.RolRepository;
import com.diplomado.users.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImple implements RolService {
    private final RolRepository rolRepository;

    public RolServiceImple(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    //Read
    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }
    //read one rol
    @Override
    public Optional<Rol> getRolById(Integer id) {
        return rolRepository.findById(id);
    }
    //Create o update
    @Override
    public Rol createOrUpdateRol(Rol rol) {
        return rolRepository.save(rol);
    }
    //Delete
    @Override
    public void deleteRolById(Integer id) {
        rolRepository.deleteById(id);
    }
}
