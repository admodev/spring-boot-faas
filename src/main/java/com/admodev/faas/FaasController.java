package com.admodev.faas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FaasController {
  @Bean
  public Function<String, String> function() {
    return input -> {
      return "Hola " + input;
    };
  }

  @Bean
  public Consumer<String> consume() {
    return input -> {
      System.out.println("Consumidor sin salida " + input);
    };
  }

  @Bean
  public Supplier<String> supply() {
    return () -> {
      return "Salida sin consumir nada.";
    };
  }
}
