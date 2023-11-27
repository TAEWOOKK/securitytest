package com.example.securitytest.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WebErrorController {
//develop

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        System.out.println(status);
        if(status != null){
            int statusCode = Integer.parseInt(status.toString());
            System.out.println(statusCode);
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404error";
            } else {
                return "error/error";
            }
        }

        return "error/error";
    }

}


