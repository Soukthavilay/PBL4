package withUSB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectDB_DAO;
import model.bean.Gate;

public class GateClient {
	private  String Q_GET_GATE = "SELECT * FROM _GATEOFCLIENT goc "
												+ "JOIN _GATE g "
												+ "ON goc.idGate = g.idGate "
												+ "WHERE NAMECLIENT = ?";
	private  final Connection connection;
	private  PreparedStatement pst;
	private  ResultSet rs;
	public GateClient() {
		connection = ConnectDB_DAO.connectMySQL();
	}


	
	public  List<Gate> getGateOfClient(String nameClient) {
		List<Gate> list = new ArrayList<Gate>(); 
		try {
			pst = connection.prepareStatement(Q_GET_GATE);
			pst.setString(1,nameClient);
			System.out.println(pst);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				int idGate = Integer.parseInt(rs.getString(2));
				int idTypeGate =Integer.parseInt(rs.getString(3));
				String nameGate = rs.getString(6);
				Boolean status = Boolean.parseBoolean(rs.getString(5));
				Gate gate= new Gate(idGate,nameGate,idTypeGate,status);
				list.add(gate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		GateClient g = new GateClient();
		List<Gate> list = g.getGateOfClient("LAPTOP-1234");
		for(Gate i : list) {
			System.out.println(i);
		}
	}
}
