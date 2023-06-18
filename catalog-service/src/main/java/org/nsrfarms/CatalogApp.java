package org.nsrfarms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages= {"org.nsrfarms"})
@EnableEurekaClient
public class CatalogApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CatalogApp.class, args);
    }
}

