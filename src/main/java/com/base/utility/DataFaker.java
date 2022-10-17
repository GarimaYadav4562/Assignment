package com.base.utility;

import java.util.HashMap;

import com.github.javafaker.Faker;

public class DataFaker {
	static Faker faker = new Faker();
	
	//Methods
	
	public String generateZipCode(){
		return faker.address().zipCode();	
	}
	
	public String generateStreetAddress() {
		return faker.address().streetAddress();
	}

	public String generateCity() {
		return faker.address().city();
	}
	
	public String generateState() {
		return faker.address().state();
	}
	
	public String generatePhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String generateSSN() {
		return faker.idNumber().ssnValid();
	}
	
	public String generateFirstName() {
		return faker.name().firstName();
	}
	
	public String generateLastName() {
		return faker.name().lastName();
	}
	
	public String generatePassword(int minimumLength, int maximumLength) {
	     return faker.lorem().characters(minimumLength, maximumLength);
	 }
	
	public static String generateRandomNumber(int length) {
	     return faker.number().digits(length);
	 }
	
	public HashMap<String, String> getRegistrationData(){
		HashMap<String,String> data = new HashMap<>();
		data.put("firstName",generateFirstName());
		data.put("lastName", generateLastName());
		data.put("address", generateStreetAddress());
		data.put("city",generateCity());
		data.put("state", generateState());
		data.put("zipCode", generateZipCode());
		data.put("phoneNumber", generatePhoneNumber());
		data.put("ssn", generateSSN());
		data.put("password", generatePassword(8,12));
		return data;
	}
	
}
