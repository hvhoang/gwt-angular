package com.asayama.demo.server.beans;

import java.io.Serializable;

import com.asayama.demo.shared.Customer;

public class SerializableCustomer implements Customer, Serializable {

	private static final long serialVersionUID = 4580959031354344868L;

	String name;
	String city;
	
	@Override
	public String getName() {
		return name;
	}
	public Customer setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getCity() {
		return city;
	}
	public Customer setCity(String city) {
		this.city = city;
		return this;
	}
	
}
