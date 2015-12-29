package de.muenchen.simple.service.simple.web;

import de.muenchen.simple.service.simple.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return this.service.greet();
    }
    
}
