package fr.charbo.velov.integration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource(value = "classpath:default_parameters.properties", ignoreResourceNotFound = true),
        @PropertySource(value = "classpath:custom_parameters.properties", ignoreResourceNotFound = true)
})
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:/integration.xml")
public class IntegrationConfiguration {
}
