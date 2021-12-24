package model.BO;


import java.util.List;

import model.DAO.ConnectionDAO;
import model.DAO.Device_DAO;
import model.bean.Device;
import model.bean.DeviceConnectDto;

public class Device_BO {

	

	//public static Map<Device,LocalDateTime> getDeviceConnectBO() {
		
		//Examp.alwayCheck();
		//return Examp.devices;
	//}
	public static List<Device> getAllDevice(){
		return Device_DAO.getAllDeviceDAO();
	}
	public static List<Device> getDeviceByClient(int idClient){
		List<Device> listDevice =  Device_DAO.getAllDeviceDAO();
		return listDevice;
				
	}
	public static List<DeviceConnectDto> getDevConnected(String nameClient){
		return ConnectionDAO.getDeviceConnect(nameClient);
	}
	public static String getDevice(int idDevice) {
		return Device_DAO.getDeviceByID(idDevice).getNameDevice();
	}
}
