package de.muenchen.simple.foo.service.domain;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author claus
 */
public interface FooRepository extends CrudRepository<Foo, Long>{
    
}
