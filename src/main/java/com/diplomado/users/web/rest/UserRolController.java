package com.diplomado.users.web.rest;

import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users/{user_id}/rol")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping//ok
    public ResponseEntity<List<UserRolDTO>> listEnrollmentsByUser(@PathVariable final Long user_id) {
        return ResponseEntity.ok().body(userRolService.getAllUserRol(user_id));
    }

    @PostMapping//ok
    public ResponseEntity<UserRolDTO> save(@RequestBody final UserRolDTO userRolDTO) throws URISyntaxException {

        if (userRolDTO.getId() != null) {
            throw new IllegalArgumentException("I new course cannot already have an id.");
        }

        userRolDTO.setCreate_at(LocalDateTime.now());
        UserRolDTO userRolDB = this.userRolService.save(userRolDTO);

        return ResponseEntity
                .created(new URI("/v1/users/"+ userRolDB.getUser().getId() + "/rol/" + userRolDB.getId()))
                .body(userRolDB);

    }
}
