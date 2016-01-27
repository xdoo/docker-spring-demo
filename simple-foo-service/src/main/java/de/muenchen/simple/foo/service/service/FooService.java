package de.muenchen.simple.foo.service.service;

import de.muenchen.simple.foo.service.domain.Foo;
import de.muenchen.simple.foo.service.domain.FooRepository;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FooService(FooRepository repo) {
        this.repo = repo;
    }
    
    
    public Long saveBar() {
        String bar = new BigInteger(130, random).toString(32);
        this.log.info(String.format("saving hash '%s'", bar));
        return this.repo.save(new Foo(bar)).getId();
    }
    
    public String loadBar(Long id) {
        this.log.info(String.format("loading hash for is '%s'", id));
        return this.repo.findOne(id).getBar();
    }
    
}
