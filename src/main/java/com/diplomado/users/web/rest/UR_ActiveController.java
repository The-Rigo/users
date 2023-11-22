package com.diplomado.users.web.rest;

import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UR_ActiveController {
    private final UserRolService userRolService;

    public UR_ActiveController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping("/{idRol}/user-rol")//ok
    public ResponseEntity<List<UserRolDTO>> listUserByRolID(@PathVariable final Integer idRol) {
        return ResponseEntity.ok().body(userRolService.getUserRol(idRol));
    }

    @PatchMapping("/active/{userRolID}")//mal
    public ResponseEntity<UserRolDTO> editActive(@RequestBody final UserRolDTO userRolDTO,
                                                 @PathVariable final Integer userRolID ) throws URISyntaxException {

        Optional<UserRolDTO> existente = userRolService.getUserRolById(userRolID);
        if (userRolDTO.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, the value is null");
        }
        if (!Objects.equals(userRolDTO.getId(), userRolID)) {
            throw new IllegalArgumentException("the user id do not exist");
        }

        userRolDTO.setCreate_at(existente.get().getCreate_at());
        userRolDTO.setUser(existente.get().getUser());
        userRolDTO.setRol(existente.get().getRol());
        return ResponseEntity
                .ok()
                .body(this.userRolService.save(userRolDTO));

    }
}
