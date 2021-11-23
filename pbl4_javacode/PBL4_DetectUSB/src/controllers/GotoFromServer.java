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
import model.bean.Account;
import model.bean.Clients;

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
		
		Account account = Account_BO.getAccount(userName, passWord);
		List<Clients> listClient = Client_BO.getAllClient();
		if(account == null) {
			response.sendRedirect("FormLogin.jsp");
		}
		else {
			request.getSession().setAttribute("account",account);
			request.getSession().setAttribute("listClient",listClient);
			response.sendRedirect("FormServer.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
