/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.muenchen.simple.sub.service.simple.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    
    private final String ip;
    
    @Value("${my.property}")
    private String myproperty;
    
    @Value("${my.default}")
    private String mydefault;

    public HelloWorldService() throws UnknownHostException {
        this.ip = InetAddress.getLocalHost().getHostAddress();
    }

    public String getHelloMessage(String name) throws UnknownHostException {
        return "Hello " + name + " from " + this.ip + String.format(" profile prop > '%s', default prop > '%s'", this.myproperty, this.mydefault);
    }

}
