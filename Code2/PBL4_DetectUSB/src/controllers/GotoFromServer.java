package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.Account_BO;
import model.BO.Client_BO;
import model.BO.Connect_BO;
import model.BO.Device_BO;
import model.bean.Account;
import model.bean.Clients;
import model.bean.Connect;
import model.bean.DeviceConnectDto;
import withUSB.Examp;

@WebServlet("/GotoFromServer")
public class GotoFromServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GotoFromServer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(userName + " ===" + passWord);
		Examp ex = new Examp();
		ex.alwayCheck();
		
		Account account = Account_BO.getAccount(userName, passWord);
		List<Clients> listClient = Client_BO.getAllClient();
		for(Clients i : listClient) {
			System.out.println(i);
		}

		if(account != null && account.isDecen()) {
			request.getSession().setAttribute("account",account);
			request.getSession().setAttribute("listClient",listClient);
			response.sendRedirect("FormServer.jsp");
		}
		else if(account != null && Client_BO.checkLogin(userName)) {
			String nameClient = ex.getComputerName();
			List<DeviceConnectDto> listDev = Device_BO.getDevConnected(nameClient);
			request.getSession().setAttribute("client", nameClient);
			request.getSession().setAttribute("listDev", listDev);;
			response.sendRedirect("FromUSB.jsp");
		}
		else {
			response.sendRedirect("FormLogin.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);		
	}

}
