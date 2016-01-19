package de.muenchen.simple.foo.service.service;

import de.muenchen.simple.foo.service.domain.Foo;
import de.muenchen.simple.foo.service.domain.FooRepository;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
public class FooService {
    
    private final FooRepository repo;
    
    private final SecureRandom random = new SecureRandom();

    @Autowired
    public FooService(FooRepository repo) {
        this.repo = repo;
    }
    
    
    public Long saveBar() {
        String bar = new BigInteger(130, random).toString(32);
        return this.repo.save(new Foo(bar)).getId();
    }
    
    public String loadBar(Long id) {
        return this.repo.findOne(id).getBar();
    }
    
}
