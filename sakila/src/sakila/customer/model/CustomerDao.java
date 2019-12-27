package sakila.customer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sakila.address.model.Address;
import sakila.db.DBHelper;

public class CustomerDao {
	public List<Customer> selectCustomerList(){
		List<Customer> list = new ArrayList<Customer>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from customer limit 10";
		try {
			conn = DBHelper.getconnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setStoreId(rs.getInt("store_id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(new Address());
	   			customer.getAddress().setAddressId(rs.getInt("address_id"));
				customer.setActive(rs.getInt("active"));
				customer.setCreateDate(rs.getString("create_date"));
				customer.setLastUpdate(rs.getString("last_update"));
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(rs, stmt, conn);
		}
		return list;
	}

	public void insertCustomer(Connection conn, Customer customer) throws Exception {
		// Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "INSERT INTO customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update) values(?,?,?,?,?,1,now(),now()) ";

		stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();

	}

	public int selectCustomerCount() {
		int count = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from customer";

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
