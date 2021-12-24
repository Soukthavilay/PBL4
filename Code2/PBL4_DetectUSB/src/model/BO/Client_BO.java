package model.BO;

import java.util.List;
import java.util.stream.Collectors;

import model.DAO.Client_DAO;
import model.bean.Clients;
import withUSB.Examp;

public class Client_BO {
	public static List<Clients> getAllClient(){
		return Client_DAO.getAllClient();
	}

	public static boolean checkLogin(String Mail) {
		Examp ex = new Examp();
		List<Clients> list = Client_DAO.getAllClient()
									   .stream()
									   .filter(item -> item.getMailManager().equals(Mail))
									   .filter(item -> item.getNameClient().equals(ex.getComputerName()))
									   .collect(Collectors.toList());
		if(list.size() == 0)
			return false;
		else 
			return true;
				
	}
}
