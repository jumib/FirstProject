package com.example.demo.controller;

import com.example.demo.entity.FilePond;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Log
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FilePondController {

    @PostMapping("/files")
    public ResponseEntity<FilePond> register (
            @Validated @RequestBody  FilePond files,
            UriComponentsBuilder uriBuilder) throws Exception {
        log.info("POST register()");

        // service.register(files);

        // log.info("register board.getBoardNo() = " + files.);

        return new ResponseEntity<>(files, HttpStatus.OK);
    }
}
