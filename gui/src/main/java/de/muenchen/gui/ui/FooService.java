package de.muenchen.gui.ui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author claus
 */
@Service
public class FooService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void plusOne(FooBean foo) {
        foo.setX(foo.getX() + 1);
        try {
            log.info(String.format("number: %s on '%s'", foo.getX(), InetAddress.getLocalHost().getHostAddress()));
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(FooService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
