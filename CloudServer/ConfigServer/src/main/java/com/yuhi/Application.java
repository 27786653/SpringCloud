package com.yuhi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Application {
	/**
	 * URL与配置文件的映射关系如下：
		/{application}/{profile}[/{label}]
		/{application}-{profile}.yml
		/{label}/{application}-{profile}.yml
		/{application}-{profile}.properties
		/{label}/{application}-{profile}.properties
		上面的url会映射{application}-{profile}.properties对应的配置文件，
		{label}对应git上不同的分支，默认为master。
	 * @param args
	 */
	//URl： http://localhost:10003/cloud/config-test
	//url:http://localhost:10003/cloud-config/test
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}