package sakila.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.CountryDao;

@WebServlet("/SelectCountryCount")
public class SelectCountryCount extends HttpServlet {
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		countryDao = new CountryDao();
		int count = countryDao.selectCountryCount();
		Gson gson = new Gson();
		String jsoncount = gson.toJson(count);
		response.getWriter().write(jsoncount);
	}

}
