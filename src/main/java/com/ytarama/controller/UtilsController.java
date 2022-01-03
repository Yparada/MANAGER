package com.ytarama.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/utils")
public class UtilsController {

    @GetMapping(path = "/health")
    public String health(){
        return "OK MAN";
    }
}
