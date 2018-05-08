package org.ufox.rubik.optimus;

import org.ufox.rubik.optimus.support.v.APP;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(Application.class).run(args);
    }

    @Bean(name = "app")
    public APP app() {
        return new APP();
    }
}
