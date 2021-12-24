package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.Connect_BO;
import model.BO.Device_BO;
import model.bean.Connect;
import model.bean.DeviceConnectDto;



@WebServlet("/GotoViewDeviceServlet")
public class GotoViewDeviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GotoViewDeviceServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


			String nameClient = request.getParameter("nameclient");
			//write method split space
			System.out.println(nameClient);
			List<DeviceConnectDto> listDev = Device_BO.getDevConnected(nameClient);

			if(nameClient == "") {
				response.sendRedirect("FormServer.jsp");
			}
			else {
				request.getSession().setAttribute("client", nameClient);
				request.getSession().setAttribute("listDev", listDev);;
				response.sendRedirect("FromUSB.jsp");
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
