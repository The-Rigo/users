package com.diplomado.users.web.rest;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.services.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> getAllRoles(){
        return rolService.getAllRoles();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id){
        Optional<Rol> rol = rolService.getRolById(id);
        return rol.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> createOrUpdateRol(@RequestBody Rol rol){
        Rol createdOrUpdatedRol = rolService.createOrUpdateRol(rol);
        return new ResponseEntity<>(createdOrUpdatedRol, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolById(@PathVariable Integer id) {
        rolService.deleteRolById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
