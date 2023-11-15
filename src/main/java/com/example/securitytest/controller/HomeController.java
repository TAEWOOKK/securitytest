package com.example.securitytest.controller;

import com.example.securitytest.entity.member;
import com.example.securitytest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/home")
    public String hometothome(){
        return "home";
    }

    @GetMapping("/signup")
    public String signupF(){
        return "signup";
    }
    @PostMapping("/signup")
    public String signupP(member member){
        System.out.println(member);
        memberService.signup(member);

        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginpage")
    public String loginpage(){
        return "oldlogin";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
