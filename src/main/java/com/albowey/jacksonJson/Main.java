package com.albowey.jacksonJson;

import java.net.URL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		// https://www.logicbig.com/tutorials/misc/jackson/getting-started.html
		// http://tutorials.jenkov.com/java-json/jackson-objectmapper.html
		

//		String s = "{\"id\": 1, \"breed\": \"Afador\", \"url\": \"http://www.dogbreedinfo.com/afador.htm\"}";		
//		String s = "[{\"id\": 1, \"breed\": \"Afador\", \"url\": \"http://www.dogbreedinfo.com/afador.htm\"}, {\"id\": 2, \"breed\": \"Afaird\", \"url\": \"http://www.dogbreedinfo.com/afaird.htm\"}]";

//		String s = "{\"ID\": 1, \"Breed\": \"Afador\", \"Url\": \"http://www.dogbreedinfo.com/afador.htm\"}";
//		String s = "[{\"ID\": 1, \"Breed\": \"Afador\", \"Url\": \"http://www.dogbreedinfo.com/afador.htm\"}, {\"ID\": 2, \"Breed\": \"Afaird\", \"Url\": \"http://www.dogbreedinfo.com/afaird.htm\"}]";		

 		URL s = new URL("https://mysafeinfo.com/api/data?list=dogbreeds&format=json");
		
		SimpleModule module = new SimpleModule();
        ObjectMapper mapper = new ObjectMapper();

		module.addDeserializer(DogBreed.class, new DogBreedDeserializer(DogBreed.class));  
		mapper.registerModule(module);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

//		DogBreed dogBreed = mapper.readValue(s, DogBreed.class);		
//      System.out.println(dogBreed);
        
        List<DogBreed> dogBreeds = mapper.readValue(s, new TypeReference<List<DogBreed>>(){});
        for (DogBreed breed: dogBreeds) {
        	System.out.println(breed.toString());
        }
	}
}
