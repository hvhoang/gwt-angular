package com.asayama.demo.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asayama.demo.server.beans.SerializableCustomer;
import com.asayama.demo.shared.Customer;

@Path("/customer")
public class CustomerService {

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Customer> getCustomers() {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new SerializableCustomer().setName("Yuki").setCity("New York"));
		list.add(new SerializableCustomer().setName("Sarah").setCity("New York"));
		return list;
	}
}
