package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.bean.Clients;

public class Client_DAO {
	public static void main(String[] args) {
		for(Clients i : getAllClient()) {
			System.out.println(i);
		}
	}
	public static List<Clients> getAllClient(){
		Connection connection = ConnectDB_DAO.connectMySQL();
		List<Clients> listClients = new ArrayList<Clients>();
		String query = "Select * from _Client";
		try {
			Statement stmt = connection.createStatement();
			ResultSet result =  stmt.executeQuery(query);
			while(result.next()) {
				
				String nameClient = result.getString(1);
				String mailManager = result.getString(2);
				int idArea = Integer.parseInt(result.getString(3));
				DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime timeOutLast = LocalDateTime.parse(result.getString(4),df);

				boolean status = Boolean.parseBoolean(result.getString(5));
				Clients client = new Clients(nameClient,mailManager,idArea,timeOutLast,status);
				listClients.add(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
		return listClients;

	}

}
