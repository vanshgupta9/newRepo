package com.vansh.journalAppp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeathCheck {

    @GetMapping("/health-check") // map ho jeaga is end point se [end point means  jo bracket ke andr aei]
    public String healthcheck(){
        return "or bhai kessa hai";

    }
}
