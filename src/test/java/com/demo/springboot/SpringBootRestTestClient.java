package com.demo.springboot;
 
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.api.model.SwapRequest;
import com.demo.api.model.SwapResponse;
 

public class SpringBootRestTestClient {
 
    public static final String REST_SERVICE_URI = "https://demo-api-swap.herokuapp.com/SpringBootRestApi/api";
    
    @Test
    private static void swap() {
        System.out.println("Testing swap API----------");
        RestTemplate restTemplate = new RestTemplate();
        SwapRequest req = new SwapRequest();
        req.setFunnyStr("VEhFIFdPUkxE");
        ResponseEntity<SwapResponse> res = restTemplate.postForEntity(REST_SERVICE_URI+"/swap/", req, SwapResponse.class);
        System.out.println("Encode FunnyStr : "+res.getBody().getEncodeFunnyStr());
        System.out.println("Decode FunnyStr : "+res.getBody().getDecodeFunnyStr());
        System.out.println("Swap : "+res.getBody().getSwap());
        System.out.println("Encode Swap : "+res.getBody().getEncodeSwap());
        //assertEquals("25/01/2555", format.parseSimpleThaiFormat(calendar.getTime()));
    }
    
    public static void main(String[] args) {
    	swap();
    }
}