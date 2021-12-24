package model.BO;

import model.DAO.Account_DAO;
import model.bean.Account;

public class Account_BO {
	public static Account getAccount(String userName, String passWord) {
		return Account_DAO.getAccount_DAO(userName, passWord);
	}

}
