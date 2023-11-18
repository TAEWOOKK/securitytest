package com.example.securitytest.controller;

import com.example.securitytest.entity.member;
import com.example.securitytest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String idnex(){
        return "index";
    }

    @RequestMapping("/home")
    public String hometothome(){
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Principal principal){

        System.out.println(principal);
        return "hello";
    }
}
