package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.bean.Device;

public class Device_DAO {
	static Connection connection= ConnectDB_DAO.connectMySQL();
	public static List<Device> getAllDeviceDAO(){
		List<Device> listDevice = new ArrayList<Device>();
		String query = "Select * from _Device";
		try {
			Statement stmt = connection.createStatement();
			ResultSet result =  stmt.executeQuery(query);
			while(result.next()) {
				Device device = new Device(Integer.parseInt(result.getString(1)), result.getString(2),result.getString(3), Integer.parseInt(result.getString(4)),Integer.parseInt(result.getString(5)));
				listDevice.add(device);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return listDevice;
	}
	public static void main(String[] args) {
		System.out.println(getDeviceConnect(new Device(9488,2362)));
	}
	public static Device getDeviceConnect(Device device ) {
		List<Device> list = getAllDeviceDAO();	
		return  list.stream()
				    .filter(item -> item.getIdvendor() == device.getIdvendor())
				    .filter(item -> item.getIdDevice() == device.getIdDevice())
				    .findFirst().orElse(null);
	}
	

}
