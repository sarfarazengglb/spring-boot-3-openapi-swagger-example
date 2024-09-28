# Swagger Integration in Spring Boot 3

This guide provides implementation details for integrating Swagger for REST API documentation in a Spring Boot 3 application.

You can follow on Medium

https://medium.com/@sarfarazengglb/spring-boot-3-easy-swagger-integration-for-rest-api-documentation-69836767e803

## Prerequisites

- JDK 21 or higher
- Maven

## Step 1: Create a Spring Boot Project

Generate a new Spring Boot project using [Spring Initializr](https://start.spring.io/) with the following settings:

- **Group**: `com.springboot.example`
- **Artifact**: `docs`
- **Dependencies**:
    - Spring Web
    - SpringDoc OpenAPI UI

## Step 2: Update `pom.xml`

Add the following dependencies to your `pom.xml`:

```xml
<properties>
    <java.version>21</java.version>
    <springdoc.version>2.1.0</springdoc.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>${springdoc.version}</version>
    </dependency>
</dependencies>
```

## Step 3: Configure Swagger

Create a configuration class to enable Swagger:

```java
import org.springdoc.core.annotations.EnableOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    // Additional configurations can be added here
}
```

## Step 4: Run the Application

Use the following command to run your application:

```bash
./mvnw spring-boot:run
```

## Step 5: Access Swagger UI

Visit `http://localhost:8080/api/swagger-ui.html` to view the Swagger documentation for your REST API.

## Conclusion

You have successfully integrated Swagger into your Spring Boot application for REST API documentation.
