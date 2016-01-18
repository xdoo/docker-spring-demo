package de.muenchen.simple.foo.service.service;

import de.muenchen.simple.foo.service.domain.Foo;
import de.muenchen.simple.foo.service.domain.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author claus
 */
public class FooService {
    
    private final FooRepository repo;

    @Autowired
    public FooService(FooRepository repo) {
        this.repo = repo;
    }
    
    
    public Long saveBar(String bar) {
        return this.repo.save(new Foo(bar)).getId();
    }
    
}
