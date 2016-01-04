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
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author claus
 */
@Service
public class HelloWorldService {
   
    private HelloWorldClient client;
    private String ip;

    @Autowired
    public HelloWorldService(HelloWorldClient client) throws UnknownHostException {
        this.client = client;
        this.ip = InetAddress.getLocalHost().getHostAddress();
    }
    
    public String greet() {
        return this.client.getGreet() + " over " + ip;
    }
    
}
