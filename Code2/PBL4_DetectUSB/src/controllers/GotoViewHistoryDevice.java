package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.Connect_BO;
import model.BO.Device_BO;


@WebServlet("/GotoViewHistoryDevice")
public class GotoViewHistoryDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GotoViewHistoryDevice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String values = request.getParameter("idDevice");
		int idex = values.indexOf("$");
		int idDevice = Integer.parseInt(values.substring(0, idex));
		String nameClient = values.substring(idex+1, values.length());
		Map<LocalDateTime, LocalDateTime> maptime =  Connect_BO.getTimeConn(idDevice, nameClient);
		request.getSession().setAttribute("nameClient", nameClient);
		request.getSession().setAttribute("nameDevice", Device_BO.getDevice(idDevice));

		request.getSession().setAttribute("mapTime", maptime);
		response.sendRedirect("ViewConnectOfUSB.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
