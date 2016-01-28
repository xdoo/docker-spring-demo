/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.simple.service.simple.services;

import org.springframework.stereotype.Service;
import de.muenchen.simple.service.simple.web.clients.HelloWorldClient;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author claus
 */
@Service
public class HelloWorldService {
   
    private final HelloWorldClient client;
    private final String ip;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HelloWorldService(HelloWorldClient client) throws UnknownHostException {
        this.client = client;
        this.ip = InetAddress.getLocalHost().getHostAddress();
    }
    
    public String greet() {
        this.log.info("asking for hello world message...");
        return this.client.getGreet() + " over " + ip;
    }
    
}
