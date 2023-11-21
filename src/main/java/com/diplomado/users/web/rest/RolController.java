package com.diplomado.users.web.rest;


import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.services.RolService;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/roles")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAllRoles(){
        return ResponseEntity.ok().body(rolService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id){
        return ResponseEntity.ok().body(rolService.getRolById(id).orElseThrow(()-> new IllegalArgumentException()));
    }

    @PostMapping
    public ResponseEntity<RolDTO> save(@RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null){
            throw new IllegalArgumentException("I new course cannot already have an id.");
        }
        RolDTO rolDTO =this.rolService.save(dto);

        return ResponseEntity
                .created(new URI("/v1/roles/"+rolDTO.getId()))
                .body(rolDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> edit(@PathVariable final Integer id, @RequestBody final RolDTO dto) throws URISyntaxException{
        if (dto.getId() != null){
            throw new IllegalArgumentException("Invalid course id, null value");
        }
        if (!Objects.equals(dto.getId(),id)){
            throw  new IllegalArgumentException("Invalid id_rol");
        }
        return ResponseEntity.ok().body(this.rolService.edit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable final Integer id){
        rolService.deleteRolById(id);
        return ResponseEntity.noContent().build();
    }

}
