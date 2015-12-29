/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.simple.sub.service.simple.web;

import de.muenchen.simple.sub.service.api.Greeter;
import de.muenchen.simple.sub.service.simple.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author claus
 */
@RestController
public class HelloWorldController {
    
    private final HelloWorldService service;
    
    @Autowired
    public HelloWorldController(HelloWorldService service) {
        this.service = service;
    }

    @RequestMapping("/greet")
    public String greet(@RequestParam(value="name", defaultValue="World") String name) {
        return this.service.getHelloMessage(name);
    }
    
}
