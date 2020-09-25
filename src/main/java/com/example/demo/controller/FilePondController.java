package com.example.demo.controller;

import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;

@Log
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FilePondController {

    @PostMapping("/files")
    public ResponseEntity<String> create(@RequestParam("test") MultipartFile mfile) throws Exception {
        String savepath = "/Users/jumibaek/Desktop/savefiles";
        String filename = mfile.getOriginalFilename();
        File folder = new File(savepath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // File nfile = new File( savepath + File.separator + filename);
        File serverFile = new File(savepath + File.separator + filename);
        mfile.transferTo(serverFile);

        return new ResponseEntity<String>(serverFile.getAbsolutePath(), HttpStatus.OK);
    }

    @DeleteMapping("/files")
    public ResponseEntity<Void> remove(@RequestBody String path) throws Exception {
        log.info("path : " + path);

        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
