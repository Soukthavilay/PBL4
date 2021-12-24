package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.bean.Limit;
import utils.SqlUtils;

public class Limit_DAO {
	private static final String Q_GET_LIMIT = "SELECT * FROM _limit WHERE idLimit = ?";
	
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Connection connection;
	
	public static void main(String[] args) {
		SqlUtils.print(getLimitByID(1));
	}
	public static List<Limit> getLimitByID(int id){
		List<Limit> list = new ArrayList<Limit>();
		connection = ConnectDB_DAO.connectMySQL();
		try {
			pst = connection.prepareStatement(Q_GET_LIMIT,PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, id+"");
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Limit(rs.getInt(1),rs.getString(2)));
			}
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	
	
}
