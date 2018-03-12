package com.mortgage.leads.web.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.leads.persistence.domain.Customer;
import com.mortgage.leads.utils.config.AppConfig;
import com.mortgage.leads.web.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Customer Controller", produces= MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	AppConfig appConfig;
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@RequestMapping(value = "/greetings", method = RequestMethod.GET, produces = { "application/JSON" } )	
	public Map<String, String> greetings(Principal principal) {
		
		return Collections.singletonMap("content", "Hello, " + principal.getName());
	}
	
	@RequestMapping(value = "/hearbeat", method = RequestMethod.GET, produces = { "application/JSON" } )	
	public String hearbeat() {
		String response = "Welcome to Mortgage Leads." ;
		return response ;
	}
	
	@ApiOperation("Leads App Info")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = String.class )})
	@RequestMapping(value = "/appinfo", method = RequestMethod.GET, produces = { "application/JSON" } )	
	public ResponseEntity<String> appinfo() {
		String response = "Seal Id: " + appConfig.getSealid() + "\n" + 
				"App Name: " + appConfig.getName() + "\n" + 
				"App Desc: " + appConfig.getDescription() + ", TimeStamp: " + LocalDate.now();
		HttpHeaders responseHeaders = new HttpHeaders();
		System.out.println("MAPS AppInfo Called...");
		return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
	}

	@ApiOperation("Get all leads")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { "application/JSON" }, consumes = {"application/JSON"} )
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerService.getLeads();
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(customers, responseHeaders, HttpStatus.OK);
	}

	@ApiOperation("Get lead by Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/customer/{Id}", method = RequestMethod.GET, produces = { "application/JSON" }, consumes = {"application/JSON", "application/XML"} )
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value="Id") String Id) {
		Customer customer = customerService.getLeadById(Id);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(customer, responseHeaders, HttpStatus.OK);
	}
	
	@ApiOperation("Create leads")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { "application/JSON" }, consumes = {"application/JSON", "application/XML"} )	
	public ResponseEntity<List<Customer>> createCustomer(@Valid @RequestBody List<Customer> customers) {
		customers = customerService.saveLead(customers);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(customers, responseHeaders, HttpStatus.OK);
	}

	@ApiOperation("Update lead by Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { "application/JSON" }, consumes = {"application/JSON", "application/XML"} )
	public List<Customer> updateCustomer(@PathVariable(value = "Id") int Id, @RequestBody Customer customer) {
		//return customerService.updateCustomer(Id, customer);
		return null;
	}

	@ApiOperation("Delete lead by Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/delete/{Id}", method = RequestMethod.DELETE, produces = { "application/JSON" }, consumes = {"application/JSON", "application/XML"} )
	public List<Customer>  deleteCustomer(@PathVariable(value="Id") String Id) {
		return customerService.deleteCustomer(Id);
	}
}
