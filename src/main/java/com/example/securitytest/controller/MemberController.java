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
    @GetMapping("/signup")
    public String signupF(){
        return "signup";
    }
    @PostMapping("/signup")
    public String signupP(member member){

        memberService.signup(member);

        return "login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/loginpage")
    public String loginpage(){
        return "oldlogin";
    }

}
