package com.diplomado.users.web.rest;


import com.diplomado.users.dto.UserDTO;
import com.diplomado.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping//ok
    public ResponseEntity<List<UserDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(userService.listUsersDetailed());
        } else {
            return ResponseEntity.ok().body(userService.listUsers());
        }
    }

    @GetMapping("/{id}")//ok
    public ResponseEntity<UserDTO> getUsersDetail(@PathVariable final Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUsersById(id).orElseThrow(() -> new IllegalArgumentException("Not Found: " + id)));
    }
    @PostMapping//ok, valid
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("I new user cannot already have an id.");
        }
        dto.setCreatedAt(LocalDateTime.now());
        UserDTO userDTO = this.userService.save(dto);
        return ResponseEntity.created(new URI("/v1/users/"+userDTO.getId()))
                .body(userDTO);
    }
    @PutMapping("/{id}")//ok
    public ResponseEntity<UserDTO> editUser(@RequestBody final UserDTO dto, @PathVariable final Long id) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("Invalid user_id, null value");
        }
        if (Objects.equals(dto.getId(),id)){
            throw new IllegalArgumentException("Invalid user_id");
        }
        dto.setCreatedAt(LocalDateTime.now());

        return ResponseEntity.ok().body(this.userService.edit(id, dto));
    }

    @DeleteMapping("/{id}")//ok
    public ResponseEntity<Void> deleteRolById(@PathVariable final Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
