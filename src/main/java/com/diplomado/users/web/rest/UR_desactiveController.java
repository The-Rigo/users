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
public class UR_desactiveController {
    private final UserRolService userRolService;

    public UR_desactiveController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping("/{idRol}/user-rol")//ok
    public ResponseEntity<List<UserRolDTO>> listUserByRolID(@PathVariable final Integer idRol) {
        return ResponseEntity.ok().body(userRolService.getUserRol(idRol));
    }

}
