package com.example.securitytest.controller;

import com.example.securitytest.entity.member;
import com.example.securitytest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @GetMapping("/")
    public String intial(){

        return "/public/home";
    }

    @RequestMapping("/home")
    public String home(){
        return "/public/home";
    }

    @RequestMapping("/index")
    public String index(){
        return "/public/index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin/admintest";
    }


    @GetMapping("/signup")
    public String signupF(){
        return "/public/signup";
    }
    @PostMapping("/signup")
    public String signupP(member member){

        memberService.signup(member);

        return "/public/login";
    }
    @GetMapping("/login")
    public String login(){
        return "/public/login";
    }

    @GetMapping("/oldlogin")
    public String oldlogin(){
        return "/public/oldlogin";
    }
}
