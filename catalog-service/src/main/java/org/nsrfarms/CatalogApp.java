package org.nsrfarms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages= {"org.nsrfarms"})

public class CatalogApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CatalogApp.class, args);
    }
}

