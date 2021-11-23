package model.BO;

import java.util.List;

import model.DAO.Device_DAO;
import model.bean.Device;
import withUSB.Examp;

public class Device_BO {
	public static void main(String[] args) {
		for(Device i: getDeviceConnectBO()) {
			System.out.println("nice" + i);
		}
	}

	public static List<Device> getDeviceConnectBO() {
		Examp.alwayCheck();
		return Examp.devices;
	}
	public static List<Device> getAllDevice(){
		return Device_DAO.getAllDeviceDAO();
	}
}
