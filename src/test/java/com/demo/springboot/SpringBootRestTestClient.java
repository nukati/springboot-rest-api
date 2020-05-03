package com.demo.springboot;
 
import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.demo.api.model.SwapRequest;
 

public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/api";
    /* POST */
    private static void swap() {
        System.out.println("Testing swap API----------");
        RestTemplate restTemplate = new RestTemplate();
        SwapRequest req = new SwapRequest("VEhFIFdPUkxE");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/swap/", req, SwapRequest.class);
        //System.out.println("Swap : "+res.getSwap());
    }
 
    public static void main(String args[]){
    	swap();
    }
}