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
        String savepath = "/home/bitai/save";
        String filename = mfile.getOriginalFilename();
        File folder = new File(savepath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // File nfile = new File( savepath + File.separator + filename);
        File serverFile = new File(savepath + File.separator + filename);
        mfile.transferTo(serverFile);

        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> remove() throws Exception {

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

//    response.setContentType("text/plain");
//    response.setCharacterEncoding("UTF-8");
////    MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//    Iterator<String> itr =multipartHttpServletRequest.getFileNames();
//    MultipartFile mfile = null;
//        while(itr.hasNext()) {
//        String filename = itr.next();
//        System.out.println(filename);
//        mfile = multipartHttpServletRequest.getFile(filename);
//        String origName;
//        origName=new String(mfile.getOriginalFilename());
//        if ("".equals(origName))
//        {
//            continue;
//        }
//        String path = "c://";
//        File serverFile = new File(path +origName );
//        mfile.transferTo(serverFile);
//    }
//
//        response.getWriter().print("12345")

