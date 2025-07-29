package com.ojash.socialmedia.controllers;

import com.ojash.socialmedia.models.SocialUser;
import com.ojash.socialmedia.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> getUsers(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.OK);
    }

    @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long userId){
        String result = socialService.deleteUser(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
