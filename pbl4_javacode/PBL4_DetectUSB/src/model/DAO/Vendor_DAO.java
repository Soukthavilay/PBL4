package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.bean.Vendor;

public class Vendor_DAO {
	public static void main(String[] args) {
		List<Vendor> listVendor = getAllVendorDAO();
		for(Vendor i : listVendor) {
			System.out.println(i);
		}
	}
	public static List<Vendor> getAllVendorDAO(){
		List<Vendor> listVendor = new ArrayList<Vendor>();
		Connection connection= ConnectDB_DAO.connectMySQL();
		String query = "Select * from vendor";
		try {
			Statement stmt = connection.createStatement();
			ResultSet result =  stmt.executeQuery(query);
			while(result.next()) {
				Vendor vendor = new Vendor(Integer.parseInt(result.getString(1)), result.getString(2));
				listVendor.add(vendor);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return listVendor;
	}

}


