package com.mortgage.maps.web.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.mortgage.maps.persistence.domain.Customer;
import com.mortgage.maps.utils.config.AppConfig;
import com.mortgage.maps.web.service.MapsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/mortgage")
public class MapsController {

	@Autowired
	MapsService mapsService;

	@Autowired
	AppConfig appConfig;

	List<Customer> customers = new ArrayList<Customer>();

	@ApiOperation("Maps Config Info")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = String.class) })
	@RequestMapping(value = "/appinfo", method = RequestMethod.GET, produces = { "application/JSON" })
	public ResponseEntity<String> appinfo() {
		String response = "Seal Id: " + appConfig.getSealid() + "\n" + "App Name: " + appConfig.getName() + "\n"
				+ "App Desc: " + appConfig.getDescription() + ", TimeStamp: " + LocalDate.now();
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
	}
	
	@ApiOperation("Get lead by Id")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Ok", response = Customer.class )})
	@RequestMapping(value = "/customer/{Id}", method = RequestMethod.GET, produces = { "application/JSON" }, consumes = {"application/JSON", "application/XML"} )
	public ResponseEntity<Customer> getCustomer(@PathVariable(value="Id") String Id) {
		Customer customer = null;	// mapsService.fetchCustomer(Id);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(customer, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Customer> customers() {
		customers = mapsService.getCustomers();
		System.out.println("customers: " + customers);
		return customers ;
	}
	
	@ApiOperation("Create leads")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Customer.class) })
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { "application/JSON" }, consumes = {
			"application/JSON", "application/XML" })
	public ResponseEntity<List<Customer>> createCustomer(@Valid @RequestBody List<Customer> _customers) {
		for (Customer customer : _customers) {
			customers.add(mapsService.saveCustomer(customer));
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(customers, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{customerId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Customer> updateCustomer(@RequestBody String customerId) {
		return mapsService.updateCustomer(customerId);
	}

	@RequestMapping(value = "/delete/{customerId}", method = RequestMethod.DELETE)
	@ResponseBody
	public List<Customer> deleteCustomer(@PathVariable(value = "customerId") String customerId) {
		return mapsService.deleteCustomer(customerId);
	}

}
