Project Title: NSR Farms Online Stores
![image](https://github.com/s713278/nsr-farms/assets/14287419/3475a4d4-2bcd-434e-8f3c-57d7d7ce6983)


Technology Stack:
	1. Java 11.0.15 (https://jdk.java.net/archive/)
	2. Spring Boot - 2.7.12
	3. Spring Cloud - 2021.0.7
	4. Maven - 3.6.3 (https://maven.apache.org/download.cgi)
	5. Open API - 1.7.1
	6. Npm 8.12.1
	7. ReactJS

Java Setup:
PATH = C:\Program Files\Java\jdk-11.0.15+10\bin
CLASSPATH = C:\Program Files\Java\jdk-11.0.15+10\lib

Development & Testing Tools:
	1. SpringToolSuite
	2. Postman
	3. Visual Studio 


Local Setup Steps:
	1. Install/Setup all the required softwares and tools
	2. Checkout the code from repository  https://github.com/s713278/nsr-farms.git
	3. Import into eclipse as a maven project
	4. Navigate to <<Relative Path>>\nsr-farms
		a. Click all the batch files in sequential order one by one with 1 min interval time.
		b. Browse the following URLs
			i. http://localhost:9090/catalog-service/catalog/1
			ii. http://localhost:9090/catalog-service/catalog/category/100
			iii. http://localhost:9090/catalog-service/catalog/product/1002
	5. Zipkin Server URL - Micro Service Logs Tracing
		a. http://localhost:9411/zipkin/
	6. Eureka Server URL
		a. http://localhost:8761/
	7. API Gateway URLs
		a. http://localhost:9090/catalog-service/catalog/1
		b. http://localhost:9090/catalog-service/catalog/category/100
		c. http://localhost:9090/catalog-service/catalog/product/1002
		
	8. API Documentation URLs
		a. http://localhost:8082/v3/api-docs
		b. http://localhost:8082/swagger-ui/index.html
	9. H2 DB Console
http://localhost:8082/h2-console

![image](https://github.com/s713278/nsr-farms/assets/14287419/0efe1654-a9f1-4e52-851e-2225d71b8c8a)
