package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors")
    public ResponseEntity<?> findAllAuthors(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
}
