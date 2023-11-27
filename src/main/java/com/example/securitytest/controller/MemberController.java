package com.example.securitytest.controller;

import com.example.securitytest.entity.member;
import com.example.securitytest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/public/signup")
    public String signupF(){
        return "/public/signup";
    }
    @PostMapping("/public/signup")
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
