package com.diplomado.users.web.rest;


import com.diplomado.users.dto.UserDTO;
import com.diplomado.users.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAllUsers(){
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("I new user cannot already have an id.");
        }

        UserDTO userDTO = this.userService.save(dto);
        return ResponseEntity.created(new URI("/v1/users/"+userDTO.getId()))
                .body(userDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> editUser(@RequestBody final UserDTO dto, @PathVariable final Long id) throws URISyntaxException {
        if(dto.getId() == null){
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (Objects.equals(dto.getId(),id)){
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity.ok()
                .body(this.userService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRolById(@PathVariable final Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
