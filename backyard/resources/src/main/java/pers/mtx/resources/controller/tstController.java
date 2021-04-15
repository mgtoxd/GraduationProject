package pers.mtx.resources.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tstController {
    @GetMapping("/dwa")
    public String dwa(){
        return "wdadaw";
    }
}
