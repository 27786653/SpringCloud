package com.yuhi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.yuhi.access.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application {
	
	/**
	 * api服务网关 
	 * http://localhost:10004/api-a/add?a=1&b=2
	 * http://localhost:10004/api-b/add?a=1&b=2
	 * http://localhost:10004/api-a/add?a=1&b=2&accessToken=token
	 * @param args
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}