package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orb.PrefixParserAction;

import sakila.db.DBHelper;

public class CityDao {
	public void insertCity(City city) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into city(city, country_id, last_update) values(?,?,now())";
		try {
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, city.getCity());
			stmt.setInt(2, city.getCountry().getCountryId());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(null, stmt, conn);
		}
	}
	
	public List<City> selectCityListByCountry(int countryId){
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select city_id, city from city where country_id=?";
		try {
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,countryId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("city_id"));
				city.setCity(rs.getString("city"));
				list.add(city);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
			return list;
	}
	
	public int selectCityCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from city limit 10";
		
		try {
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
			return count;
	}
	
	public List<City> selectCityList(int currentPage){
	//city INNER JOIN country
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int ROW_PER_PAGE = 100;
		int beginRow = (currentPage - 1) * ROW_PER_PAGE;
		
		String sql = "select * from city order by city desc limit ?,?";
		try {
			conn= DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, beginRow);
			stmt.setInt(2, ROW_PER_PAGE);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				City c = new City();
				c.setCityId(rs.getInt("city_id"));
				c.setCity(rs.getString("city"));
				c.setCountry(new Country());
				c.getCountry().setCountryId(rs.getInt("country_id"));
				c.setLastUpdate(rs.getString("last_update"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
			
		return list;
	}
}
