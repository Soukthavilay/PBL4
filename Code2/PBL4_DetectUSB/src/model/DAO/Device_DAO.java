package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Device;
import model.bean.DeviceConnectDto;

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
		System.out.println(getDeviceByID(9488));
	}
	static final String Q_GET_USB_BY_ID = "SELECT d.nameDevice, v.nameVendor,d.typeDevice, tg.nameTypeGate FROM _device d"
			+ " JOIN _typegate tg ON tg.idTypeGate = d.TypeGate"
			+ " JOIN vendor v ON v.idVendor = d.idVendor"
			+ " WHERE idDevice =  ?";
	private static PreparedStatement pst;
	private static ResultSet rs;
	public static DeviceConnectDto getDeviceByID(int idDevice) {
		List<DeviceConnectDto> result = new ArrayList<DeviceConnectDto>();
		try {
			pst = connection.prepareStatement(Q_GET_USB_BY_ID,PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, idDevice);
			rs = pst.executeQuery();
			while(rs.next()) {
				String nameDevice = rs.getString(1);
				String nameVendor = rs.getString(2);
				String typeDevice = rs.getString(3);
				String TypeGate = rs.getString(4);
				DeviceConnectDto device = new DeviceConnectDto(idDevice, nameDevice,nameVendor,typeDevice,TypeGate);
				result.add(device);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.stream()
					.findFirst().orElse(null);
	}
	public static Device getDeviceConnect(Device device ) {
		List<Device> list = getAllDeviceDAO();	
		return  list.stream()
				    .filter(item -> item.getIdvendor() == device.getIdvendor())
				    .filter(item -> item.getIdDevice() == device.getIdDevice())
				    .findFirst().orElse(null);
	}
	public static int getTypeGate(int idProduct) {
		List<Device> list = getAllDeviceDAO();
		Device device=  list.stream()
				   .filter(item -> item.getIdDevice() == idProduct)
				   .findFirst().orElse(null);
		if(device!= null) {
			return device.getIdtypeGate();
		}
		else {
			return 0;
		}
	}
	

}
