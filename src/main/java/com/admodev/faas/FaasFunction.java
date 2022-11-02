package com.admodev.faas;

import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class FaasFunction implements Function<PersonaEntity, Map<String, Object>> {
  @Override
  public Map<String, Object> apply(PersonaEntity persona) {
    return Map.of( "hola", persona.getNombre(), "itemsNumber", persona.getLista().size() );
  }
}
