package model.BO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import model.DAO.ConnectionDAO;
import model.bean.Connect;

public class Connect_BO {

	public  List<Connect> getAllConnect(){
		return ConnectionDAO.getConnection();
	}
	public static Connect setConnect(Connect conn) {
		return ConnectionDAO.setConnect(conn);
	}
	public static List<Connect> getConnectOfClient(String nameClient) {
		return ConnectionDAO.getConnectbyIDClient(nameClient);
	}
	public static Map<LocalDateTime, LocalDateTime> getTimeConn(int idDevice, String nameClient){
		return ConnectionDAO.getConnectOfClientbyIDDevice(idDevice, nameClient);
	}
	public static void main(String[] args) {
		for(Connect i : getConnectOfClient("LAPTOP-6Q6JEO63")) {
			System.out.println(i);
		}
	}
	

}
