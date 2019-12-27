package sakila.address.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sakila.db.DBHelper;

public class AddressDao {
	public int insertAddress(Connection conn, Address address) throws Exception{
		int addressId = 0;
		//Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO address(address, address2, district, city_id, postal_code, phone, last_update) VALUES(?,?,?,?,?,now())";

		
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//프라이머리값을 받아올수있다.
			stmt.setString(1, address.getAddress());
			stmt.setString(2, address.getAddress2());
			stmt.setString(3, address.getDistrict());
			stmt.setInt(4, address.getCity().getCityId());
			stmt.setString(5, address.getPostalCode());
			stmt.setString(6, address.getPhone());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				addressId = rs.getInt(1);
			}
		
		return addressId;
	}

	public int selectAddressCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from address";

		try {
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return count;
	}
}
