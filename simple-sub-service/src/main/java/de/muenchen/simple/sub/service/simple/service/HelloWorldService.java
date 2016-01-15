package de.muenchen.simple.sub.service.simple.service;

import de.muenchen.simple.sub.service.simple.domain.Message;
import de.muenchen.simple.sub.service.simple.domain.MessageRepository;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    
    private final String ip;
    
    @Value("${my.property}")
    private String myproperty;
    
    @Value("${my.default}")
    private String mydefault;
    
    private final MessageRepository repo;

    @Autowired
    public HelloWorldService(MessageRepository repo) throws UnknownHostException {
        this.ip = InetAddress.getLocalHost().getHostAddress();
        this.repo = repo;
    }

    public String createHelloMessage(String name) throws UnknownHostException {
        Message msg = this.repo.save(new Message(String.format("Hello %s from ip '%s'", name, this.ip)));
        return String.format("[%s] %s", msg.getId(), msg.getHelloWorld());
    }
    
    public String getProperties() {
        return String.format("profile property > %s and default property > %s", this.myproperty, this.mydefault);
    }

}
