package de.muenchen.simple.foo.service.web;

import de.muenchen.simple.foo.service.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author claus
 */
@RestController
public class FooController {
    
    private final FooService service;

    @Autowired
    public FooController(FooService service) {
        this.service = service;
    }

    public FooController() {
        this.service = null;
    }
    
    @RequestMapping("/foo")
    public String saveBar() {
        return this.service.saveBar().toString();
    }
    
    @RequestMapping("/foo/{barid}")
    public String loadBar(@PathVariable("barid") String id) {
        return this.service.loadBar(Long.parseLong(id));
    }
    
}
