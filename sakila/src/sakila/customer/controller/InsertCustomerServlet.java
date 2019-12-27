package sakila.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.Address;
import sakila.customer.model.Customer;
import sakila.cutomer.service.CustomerService;

@WebServlet("/InsertCustomerServlet")
public class InsertCustomerServlet extends HttpServlet {
	//private AddressDao addressDao;
	//private CustomerDao customerDao;
	private CustomerService customerService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// address reques.getParameter("")
		Address address = new Address();
		//addressDao = new AddressDao();
		//int addressId = addressDao.insertAddress(address);
		
		
		// customer request.getParameter("")
		Customer customer = new Customer();
		//CustomerDao customerDao = new CustomerDao();
		//customerDao.insertCustomer(customer);
		
	}

}
