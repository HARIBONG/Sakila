package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sakila.address.model.City;
import sakila.address.model.CityDao;
import sakila.address.model.Country;

@WebServlet("/address/InsertCity")
public class InsertCity extends HttpServlet {
	private CityDao cityDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String city = request.getParameter("city");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		
		City c = new City();
		c.setCity(city);
		
		Country country = new Country();
		c.setCountry(country);
		c.getCountry().setCountryId(countryId);
		
		cityDao = new CityDao();
		
		cityDao.insertCity(c);
	}

}
