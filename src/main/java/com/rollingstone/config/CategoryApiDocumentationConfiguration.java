package com.rollingstone.config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Category REST API Resources",
                version = "V1.0",
                title = "Category REST API Full CRUD",
                contact = @Contact(
                        name = "Binit Datta",
                        email = "binit-sample-email@gmail.com",
                        url = "http://www.binitdatta.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json"},
        produces = {"application/json"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "For Further Information", url = "http://binitdatta.com")
)
public class CategoryApiDocumentationConfiguration {
}
