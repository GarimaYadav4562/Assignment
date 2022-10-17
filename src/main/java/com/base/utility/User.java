package com.base.utility;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private List<Result> results = new ArrayList<Result>();
    public List<Result> getResults() {
        return results;
    }
    public void setResults(List<Result> results) {
        this.results = results;
    }
	
    public class Result {
        private Name name;
        private Location location;
        private String email;
        private Login login;
        private String phone;
        private Id id;
        public Name getName() {
            return name;
        }
        public void setName(Name name) {
            this.name = name;
        }
        public Location getLocation() {
            return location;
        }
        public void setLocation(Location location) {
            this.location = location;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Login getLogin() {
            return login;
        }
        public void setLogin(Login login) {
            this.login = login;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public Id getId() {
            return id;
        }
        public void setId(Id id) {
            this.id = id;
        }
    }

	public class Id {
	    private String name;
	    private String value;
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getValue() {
	        return value;
	    }
	    public void setValue(String value) {
	        this.value = value;
	    }    
	}
	
	public class Location {
	    private Street street;
	    private String city;
	    private String state;
	    private String country;
	    private String postcode;
	    public Street getStreet() {
	        return street;
	    }
	    public void setStreet(Street street) {
	        this.street = street;
	    }
	    public String getCity() {
	        return city;
	    }
	    public void setCity(String city) {
	        this.city = city;
	    }
	    public String getState() {
	        return state;
	    }
	    public void setState(String state) {
	        this.state = state;
	    }
	    public String getCountry() {
	        return country;
	    }
	    public void setCountry(String country) {
	        this.country = country;
	    }
	    public String getPostcode() {
	        return postcode;
	    }
	    public void setPostcode(String postcode) {
	        this.postcode = postcode;
	    }
	}
	public class Login {
	    private String username;
	    private String password;
	    public String getUsername() {
	        return username;
	    }
	    public void setUsername(String username) {
	        this.username = username;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	}
	public class Name {
	    private String first;
	    private String last;
	    public String getFirst() {
	        return first;
	    }
	    public void setFirst(String first) {
	        this.first = first;
	    }
	    public String getLast() {
	        return last;
	    }
	    public void setLast(String last) {
	        this.last = last;
	    }
	}
	
	public class Street {
	    private Integer number;
	    private String name;
	    public Integer getNumber() {
	        return number;
	    }
	    public void setNumber(Integer number) {
	        this.number = number;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	}
	
}
