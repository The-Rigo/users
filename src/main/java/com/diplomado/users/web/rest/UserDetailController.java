package com.diplomado.users.web.rest;

import com.diplomado.users.domain.entities.UserDetail;
import com.diplomado.users.services.UserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/users/{userId}/userdetail")
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    @GetMapping
    public ResponseEntity<List<UserDetail>> listDetail(@PathVariable final Long userId){
        return ResponseEntity.ok().body(userDetailService.getUserDetailByUser(userId));
    }

    @PostMapping
    public ResponseEntity<UserDetail> createUser(@RequestBody final UserDetail userDetail) throws URISyntaxException {
        if(userDetail.getId() != null){
            throw new IllegalArgumentException("I new user_detail cannot already have an id.");
        }
        UserDetail userDetailDB = userDetailService.save(userDetail);
        return ResponseEntity.created(new URI("/v1/users/"+userDetailDB.getUser().getId()+"/userdetail/"+userDetailDB.getId())).body(userDetailDB);
    }
}
