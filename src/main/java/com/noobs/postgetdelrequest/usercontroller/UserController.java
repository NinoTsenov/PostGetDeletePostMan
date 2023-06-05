package com.noobs.postgetdelrequest.usercontroller;

import com.noobs.postgetdelrequest.dto.UserRegisterRequest;
import com.noobs.postgetdelrequest.dto.UserResponse;
import com.noobs.postgetdelrequest.entity.User;
import com.noobs.postgetdelrequest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRegisterRequest request) {
        UserResponse response = userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(id));
    }

    @DeleteMapping(path = "/{id}")
    public HttpStatus deleteUser(@PathVariable Long id) {
        userService.deletedUser(id);
        return HttpStatus.ACCEPTED;
    }
}