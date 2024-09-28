package com.springboot.example.docs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration // Indicates that this class provides Spring configuration
public class SwaggerConfig {

    // Configure the OpenAPI bean
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${server.port}") String serverPort,
            @Value("${server.servlet.context-path}") String contextPath) {

        // Create an OpenAPI instance for customizing the API documentation
        OpenAPI openAPI = new OpenAPI();

        // Setting up basic API information
        Info info = new Info()
                .title("Products API") // Title of the API
                .version("1.0.0") // Version of the API
                .description("API documentation for managing products.") // Description of the API
                .termsOfService("http://swagger.io/terms/") // Link to terms of service
                .contact(new Contact()
                        .name("DevSecOps Team") // Contact name
                        .url("http://devsecops.com/contact") // Contact URL
                        .email("support@devsecops.com")) // Contact email
                .license(new License()
                        .name("Apache 2.0") // License name
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html")); // License URL

        // Setting up the server with the injected port and context path
        Server server = new Server()
                .url(String.format("http://localhost:%s%s", serverPort, contextPath)) // Construct the server URL
                .description("Development Server"); // Description of the server

        // Set the information and servers in the OpenAPI instance
        openAPI.info(info);
        openAPI.addServersItem(server);

        return openAPI; // Return the configured OpenAPI instance
    }
}
