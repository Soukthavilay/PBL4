package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.bean.Connect;
import model.bean.DeviceConnectDto;
import withUSB.Examp;

public class ConnectionDAO {
	private static Connection connection = ConnectDB_DAO.connectMySQL();	
	
	private static final String Q_SET_CONN = "INSERT INTO _connect(nameClient,idGate,idDevice,timeStart)"
											+ "	VALUES(?, ?, ?, ?)";
	private static final String Q_UP_CONN = "UPDATE _connect"
											+ " SET timeEnd = ?"
											+ " WHERE idConnect = ? ";
	private static final String Q_GET_CONN = "SELECT MAX(idConnect)"
											+ "FROM _connect "
											+ "WHERE idDevice = ?";
	private static final String Q_GET_USB_CONN = "SELECT DISTINCT idDevice "
											+ "FROM _connect";
	
	private static final String Q_GET_CONN_USB = "SELECT timeStart, timeEnd FROM _connect "
											+ "WHERE idDevice = ? "
											+ "AND nameClient = ?";
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public ConnectionDAO() {
	}
	public static  List<Connect> getConnection() {
		
		List<Connect> listConnect = new ArrayList<Connect>();
		String query = "Select * from _connect";
		try {
			Statement stmt = connection.createStatement();
			ResultSet result =  stmt.executeQuery(query);
			while(result.next()) {
				int idGate = Integer.parseInt(result.getString(1));
				int idDevice = Integer.parseInt(result.getString(2));
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime 	timeStart = LocalDateTime.parse(result.getString(3),df);
				LocalDateTime timeEnd = LocalDateTime.parse(result.getString(4),df);
				Connect conn = new Connect(idGate, idDevice, timeStart, timeEnd);
				listConnect.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return listConnect;
	}
	public static int getIdConnect(int idProduct) {
		int IdConnect = 0;
		try {
			pst = connection.prepareStatement(Q_GET_CONN, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, idProduct);
			rs = pst.executeQuery();
			while(rs.next()) {
				IdConnect = rs.getInt(1);
			}
		} catch (Exception e) {
			IdConnect = 0;
		}
		return IdConnect;							
	}
	public static Map<LocalDateTime,LocalDateTime> getConnectOfClientbyIDDevice(int idDevice, String nameClient){
		Map<LocalDateTime,LocalDateTime> time = new HashMap<LocalDateTime, LocalDateTime>();
		try {
			pst = connection.prepareStatement(Q_GET_CONN_USB, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, idDevice);
			pst.setString(2, nameClient);
			rs = pst.executeQuery();
			while(rs.next()) {
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime 	timeStart = LocalDateTime.parse(rs.getString(1),df);
				LocalDateTime 	timeEnd = LocalDateTime.parse(rs.getString(2),df);
				time.put(timeStart, timeEnd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return time;
	}
	public static void main(String[] args) {
		List<DeviceConnectDto>  list = getDeviceConnect("LAPTOP-6Q6JEO63");
		for(DeviceConnectDto i : list) {
			System.out.println(i);
		}
		//for(Integer i : getIDDevice("LAPTOP-6Q6JEO63")){
		//	System.out.println(i);
		//}
	}
	public static List<Connect> getConnectbyIDClient(String nameClient){
		List<Connect> listConnect = new ArrayList<Connect>();
		String query = "select idgate ,idDevice,timeStart,timeEnd from "
				+ "_connect where nameClient like'"+nameClient+"'";
		try {
			Statement stmt = connection.createStatement();
			ResultSet result =  stmt.executeQuery(query);
			while(result.next()) {
				int idgate = Integer.parseInt(result.getString(1));
				int idDevice = Integer.parseInt(result.getString(2));
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime timeStart = LocalDateTime.parse(result.getString(3),df);
				LocalDateTime timeEnd;
				if(result.getString(4)!= null) {
					timeEnd = LocalDateTime.parse(result.getString(4),df);
					}
				else {
					 timeEnd = null;
				}
				Connect conn = new Connect(idgate, idDevice, timeStart, timeEnd);
				listConnect.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return listConnect;
	}
	public static List<Integer> getIDDevice(String nameClient) {
		List<Integer> listDevice = new ArrayList<Integer>();
			try {
				pst = connection.prepareStatement(Q_GET_USB_CONN, PreparedStatement.RETURN_GENERATED_KEYS);
				rs = pst.executeQuery();
				while(rs.next()) {
					listDevice.add( rs.getInt(1));
					
				}
				
			} catch (Exception e) {
				return null;
			}
			return listDevice;

	}
	public static List<DeviceConnectDto> getDeviceConnect(String nameClient){
		List<Integer> listID = getIDDevice(nameClient);
		List<DeviceConnectDto> result = new ArrayList<DeviceConnectDto>();
		for(Integer i: listID) {
			DeviceConnectDto dev = Device_DAO.getDeviceByID(i);
			result.add(dev);
		}
		return result;
	}
	public static void updateConnect(int idConnect) {
		connection = ConnectDB_DAO.connectMySQL();
		try {
			pst = connection.prepareStatement(Q_UP_CONN, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, LocalDateTime.now().toString());
			pst.setString(2, idConnect+"");
			int affectRows = pst.executeUpdate();
			if(affectRows > 0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
					rs.getInt(1);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connect setConnect(Connect conn) {
		Examp ex = new Examp();
		connection = ConnectDB_DAO.connectMySQL();
		try {
			pst = connection.prepareStatement(Q_SET_CONN, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1,ex.getComputerName());
			pst.setString(2,conn.getIdGate()+"");
			pst.setString(3, conn.getIdDevice()+"");
			pst.setString(4, conn.getTimeStart().toString());

			int affectRows = pst.executeUpdate();
			if(affectRows >0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rs!= null) rs.close();}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		return null;

	}
	
	
}
