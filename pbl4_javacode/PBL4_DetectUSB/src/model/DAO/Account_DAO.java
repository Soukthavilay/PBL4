package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.Account;

public class Account_DAO {
	static Connection connection = null;
	
	public static Account getAccount_DAO(String userName, String passWord) {
		if(check(userName, passWord)) {
			return new Account(userName,passWord);
		}
		else return null;
	}
	public static boolean check(String userName, String passWord){
		try {
		connection = ConnectDB_DAO.connectMySQL();
		String query  = "Select * from _account where userName = ? And passWord = ?";
		PreparedStatement prepare = connection.prepareStatement(query);
		prepare.setString(1, userName);
		prepare.setString(2, passWord);
		ResultSet rs = prepare.executeQuery();
		if(rs.next()) {
			return true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return false;
	}
}
