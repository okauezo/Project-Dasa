package br.com.fiap.dasa.api;

import br.com.fiap.dasa.config.DatabaseInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DasaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DasaApplication.class, args);
    }

    @Bean
    CommandLineRunner initDb() {

        return args -> DatabaseInitializer.init();
    }
}
