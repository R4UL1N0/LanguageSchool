package br.com.raulino.LanguageSchool.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Lucas Raulino dos Santos",
            email = "raulino.storage@gmail.com",
            url = "https://languageschool-production.up.railway.app"
        ),
        description = "OpenAPI Docs for Language School Management System",
        title = "Language School",
        version = "1.0"
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:8080"
        ),
        @Server(
            description = "PROD ENV",
            url = "https://r4ul1n0.github.io/"
        )
    }
)
public class OpenApiConfig {
    
}
