package com.diplomado.users.web.rest;

import com.diplomado.users.domain.entities.User;
import com.diplomado.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody final User user) throws URISyntaxException {
        if(user.getId() != null){
            throw new IllegalArgumentException("I new user cannot already have an id.");
        }
        user.setCreated_id(LocalDateTime.now());

        User userDB = userService.save(user);
        return ResponseEntity.created(new URI("/v1/users/"+userDB.getId())).body(userDB);
    }
}
