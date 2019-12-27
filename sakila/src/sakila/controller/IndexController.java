package sakila.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sakila.address.model.*;
import sakila.customer.model.CustomerDao;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private CountryDao countryDao;
	private CityDao cityDao;
	private ActorDao actorDao;
	private	CategoryDao categoryDao; 
	private CustomerDao customerDao;
	private FilmDao filmDao;
	private FilmActorDao filmActorDao;
	private	FilmTextDao filmTextDao;
	private FilmCategoryDao filmCategoryDao;
	private InventoryDao inventoryDao;
	private LanguageDao languageDao;
	private PaymentDao paymentDao;
	private RentalDao rentalDao;
	private StaffDao staffDao;
	private StoreDao storeDao;
	private AddressDao addressDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		
		Map<String,Integer> map = new HashMap< String,Integer>();
		countryDao = new CountryDao();
		int countryRow = countryDao.selectCountryCount();
		map.put("countryRow",countryRow);
	
		cityDao = new CityDao();
		int cityRow = cityDao.selectCityCount();
		map.put("cityRow",cityRow);
		
		actorDao = new ActorDao();
		int actorRow = actorDao.selectActorCount();
		map.put("actorRow",actorRow);
		
		categoryDao = new CategoryDao();
		int categoryRow = categoryDao.selectCategoryCount();
		map.put("categoryRow",categoryRow);
		
		customerDao = new CustomerDao();
		int customerRow = customerDao.selectCustomerCount();
		map.put("customerRow",customerRow);
		
		filmDao = new FilmDao();
		int filmRow = filmDao.selectFilmCount();
		map.put("filmRow",filmRow);
		
		filmActorDao = new FilmActorDao();
		int filmActorRow = filmActorDao.selectFilmActorCount();
		map.put("filmActorRow",filmActorRow);
		
		filmCategoryDao = new FilmCategoryDao();
		int filmCategoryRow = filmCategoryDao.selectFilmCategoryCount();
		map.put("filmCategoryRow",filmCategoryRow);
		
		filmTextDao = new FilmTextDao();
		int filmTextRow = filmTextDao.selectFilmTextCount();
		map.put("filmTextRow",filmTextRow);
		
		inventoryDao = new InventoryDao();
		int inventoryRow = inventoryDao.selectInventoryCount();
		map.put("inventoryRow",inventoryRow);
		
		languageDao = new LanguageDao();
		int languageRow = languageDao.selectLanguageCount();
		map.put("languageRow",languageRow);
		
		paymentDao = new PaymentDao();
		int paymentRow = paymentDao.selectPaymentCount();
		map.put("paymentRow",paymentRow);
		
		rentalDao = new RentalDao();
		int rentalRow = rentalDao.selectRentalCount();
		map.put("rentalRow",rentalRow);
		
		staffDao = new StaffDao();
		int staffRow = staffDao.selectStaffCount();
		map.put("staffRow",staffRow);
		
		storeDao = new StoreDao();
		int storeRow = storeDao.selectStoreCount();
		map.put("storeRow",storeRow);
		
		addressDao = new AddressDao();
		int addressRow = addressDao.selectAddressCount();
		map.put("addressRow",addressRow);
		
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		response.getWriter().write(jsonStr);
	}

}
