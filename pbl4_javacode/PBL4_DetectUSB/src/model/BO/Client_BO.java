package model.BO;

import java.util.List;

import model.DAO.Client_DAO;
import model.bean.Clients;

public class Client_BO {
	public static List<Clients> getAllClient(){
		return Client_DAO.getAllClient();
	}
}
