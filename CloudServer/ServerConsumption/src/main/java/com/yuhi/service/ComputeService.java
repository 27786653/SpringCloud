package com.yuhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {
	@Autowired
    RestTemplate restTemplate;
	
//	熔断器错误回调方法指定
	@HystrixCommand(fallbackMethod = "addServiceFallback")
    public String add() {
    	ResponseEntity<String> resp=restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class);
        return resp.getBody();
    }
	
	
    public String addServiceFallback() {
        return "error";
    }
}