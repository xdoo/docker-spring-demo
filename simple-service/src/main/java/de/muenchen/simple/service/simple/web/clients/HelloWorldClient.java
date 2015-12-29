/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.simple.service.simple.web.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author claus
 */
@FeignClient("simple-sub-service")
public interface HelloWorldClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/greet")
    public String getGreet();
    
}
