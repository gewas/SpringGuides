package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <a href="https://spring.io/guides/gs/consuming-rest/"/>Consuming a RESTful Web Service</a>
 */
@SpringBootApplication
public class ConsumingRestApp {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApp.class, args);
    }

    /**
     * A RestTemplate, which uses the Jackson JSON processing library to process the incoming data.
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /**
     * A CommandLineRunner that runs the RestTemplate (and, consequently, fetches our quotation) on startup.
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }

}
