package com.albowey.jacksonJson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DogBreedDeserializer extends StdDeserializer<DogBreed> {
	
    public DogBreedDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
	public DogBreed deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		// https://www.baeldung.com/jackson-deserialization

        JsonNode node = p.getCodec().readTree(p);
        
        int id = (Integer) node.get("ID").numberValue();
        String breed = node.get("Breed").asText();
        String url = node.get("Url").asText();

        return new DogBreed(id, breed, url);

	}
}
