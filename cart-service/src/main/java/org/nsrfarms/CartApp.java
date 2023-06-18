package org.nsrfarms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class CartApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CartApp.class, args);
    }
}
