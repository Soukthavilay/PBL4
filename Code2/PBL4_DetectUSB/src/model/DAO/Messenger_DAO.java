package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.bean.Messenger;


public class Messenger_DAO {
	private static final String Q_SET_MESS_FROM_CLIENT = "INSERT INTO messenger "
												+ "(idClient, idServer, timeSend, idRequest) \r\n"
												+ "values (?,?,?,?);";
	private static final String Q_SET_MESS_FROM_SERVER = "INSERT INTO messenger "
												+ "(idLimit,idClient, idServer, timeSend,) \r\n"
												+ "values (?,?,?,?);";

	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Connection connection = null;

	
	public static void setMessFromClient(Messenger mess) {
		try {
			pst = connection.prepareStatement(Q_SET_MESS_FROM_CLIENT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, mess.getNameClient());
			pst.setString(2, mess.getIdServer()+"");
			pst.setString(3, mess.getTimeSend()+"");
			pst.setString(4, mess.getIdRequest()+"");
			int affectRows = pst.executeUpdate();
			if(affectRows > 0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!= null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public static void setMessFromServer(Messenger mess) {
		try {
			pst = connection.prepareStatement(Q_SET_MESS_FROM_SERVER,PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, mess.getIdLimit());
			pst.setString(2, mess.getNameClient());
			pst.setInt(3, mess.getIdServer());
			pst.setString(4, mess.getTimeSend()+"");
			int affectRows = pst.executeUpdate();
			if(affectRows > 0) {
				rs = pst.getGeneratedKeys();
				if(rs.next()) {
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!= null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
