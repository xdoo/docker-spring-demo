package de.muenchen.simple.sub.service.simple.domain;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author claus
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
    
}
