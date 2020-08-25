package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.entity.Members;
import com.example.demo.security.AuthUtil;
import com.example.demo.service.MemberAuthService;
import com.example.demo.service.MemberService;
import com.example.demo.service.MembersService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Log
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@Controller
public class MembersController {

    @Autowired
    private MembersService service;

    @GetMapping("/getsignup")
    public String getsignup(Members members, Model model) throws Exception {
        log.info("getsignup()");

        return "members/signup";
    }

    @PostMapping("/postsignup")
    private String postsignup(Members members, Model model) throws Exception{
        log.info("postsignup()");

        service.signup(members);
        model.addAttribute("msg","complete");

        return "members/complete";
    }

    @PostMapping("/postcheck")
    private String postcheck(Members members) throws Exception{
        log.info("postcheck()");
        boolean results = service.idcheck(members);
        if(results){
            return "members/possible";
        } else {
            return "members/impossible";
        }
    }

    @GetMapping("/getidsearch")
    public String getidsearch(Members members) throws Exception{
        log.info("getidsearch()");

        return "members/idsearch";
    }

    @PostMapping("/postidsearch")
    public String postidsearch(Members members, Model model) throws Exception{
        log.info("postidsearch()");

        String results = service.idsearch(members);
        if(results.isEmpty()){
            return "members/impossible";
        } else {
            model.addAttribute("id", results);
            return "members/idfind";
        }
    }

    @GetMapping("/getpwsearch")
    public String getpwsearch(Members members) throws Exception{
        log.info("getpwsearch()");

        return "members/pwsearch";
    }

    @PostMapping("/postpwsearch")
    private String postpwsearch(Members members, Model model) throws Exception{
        log.info("postpwsearch()");

        String results = service.pwsearch(members);
        if (results.isEmpty()){
            return "members/impossible";
        } else {
            model.addAttribute("pw", results);

            return "members/pwfind";
        }
    }
}
