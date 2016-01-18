package de.muenchen.simple.foo.service.web;

import de.muenchen.simple.foo.service.service.FooService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author claus
 */
@RestController
public class FooController {
    
    private final FooService service;

    public FooController(FooService service) {
        this.service = service;
    }
    
    @RequestMapping("/greet")
    public String saveBar() {
        return this.service.saveBar(null).toString();
    }
    
}
