package com.founderz.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfiguration {
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    @Bean
    ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
    }

    private static Info apiInfo() {
        return new Info()
                .title("FOUNDERZ API SPEC")
                .version("0.0.1");
    }
}
