package at.ac.fhvie.s24.swpj4bb.touristoffice.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

// CHECKSTYLE.OFF: HideUtilityClassConstructor
@SpringBootApplication
public class Main {

  public static void main(final String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(Main.class)
        .headless(false).run(args);

  }
}

// CHECKSTYLE.ON: HideUtilityClassConstructor
