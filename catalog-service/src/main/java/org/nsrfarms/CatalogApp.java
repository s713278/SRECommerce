package org.nsrfarms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info=@Info(
					title = "Catalog API Services",
					description = "Catalog API Services Documentation",
					contact = @Contact( 
							email = "swamy.kunta@gmail.com",
							name = "Kunta Swamy"),
					version = "v1.0"
					
				),
		externalDocs =@ExternalDocumentation (
				url = "https://github.com/s713278/nsr-farms/wiki/"
				)
		
		
		)

@SpringBootApplication(scanBasePackages= {"org.nsrfarms"})
@EnableEurekaClient
public class CatalogApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CatalogApp.class, args);
    }
}

