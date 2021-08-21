package com.albowey.jacksonJson;

public class DogBreed {
	
	private int id;
	private String breed;
	private String url;
	
	public DogBreed (int id, String breed, String url) {
		this.id = id;
		this.breed = breed;
		this.url = url;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public String getBreed() {
		return this.breed;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	@Override
	public String toString() {
		return "{\n" +
				"id: " + this.id + ",\n" +
				"breed = '" + this.breed + "',\n" +
				"url = '" + this.url + "',\n" +
				"}";
	}
}
