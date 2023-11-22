package com.example.securitytest.controller;

import com.example.securitytest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String idnex(){
        return "/public/index";
    }

    @RequestMapping("/home")
    public String home(){
        return "/public/home";
    }

    @GetMapping("/hello")
    public String hello(Principal principal){

        System.out.println(principal);
        return "/user/hello";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/admin/admintest";
    }

    @GetMapping("/403error")
    public String error403(){

        return "/403error";
    }
}
