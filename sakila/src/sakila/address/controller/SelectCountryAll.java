package sakila.address.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.Country;
import sakila.address.model.CountryDao;

@WebServlet("/address/SelectCountryAll")
public class SelectCountryAll extends HttpServlet {
	private CountryDao countryDao;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		countryDao = new CountryDao();
		List<Country> list = countryDao.selectCountryAll();
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(list);//json으로 바뀔수잇는 문자열을 만들어줌
		
		response.getWriter().write(jsonStr);
	}

}
