package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.Account;

public class Account_DAO {
	static Connection connection = null;
	
	public static Account getAccount_DAO(String userName, String passWord) {
		if(check(userName, passWord) == 1) {
			return new Account(userName,passWord, true);
		}
		if(check(userName, passWord) == 2){
			return new Account(userName,passWord, false);
		}
		else return null;
	}
	public static int check(String userName, String passWord){
		try {
		connection = ConnectDB_DAO.connectMySQL();
		String query  = "Select * from _account where userName = ? And passWord = ?";
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setString(1, userName);
		prepare.setString(2, passWord);
		ResultSet rs = prepare.executeQuery();
		
		if(rs.next()) {
			Boolean check = rs.getBoolean(3);
			if(check == true) {
				return 1;
			}
			else {
				return 2;
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return 0;
	}
}
