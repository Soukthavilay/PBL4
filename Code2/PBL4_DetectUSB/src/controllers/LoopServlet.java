package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import withUSB.Examp;

@WebServlet("/LoopServlet")
public class LoopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoopServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Loop");
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				}catch (Exception e) {
					e.printStackTrace();
				}
				try {
					while(true) {
						Examp ex = new Examp();
						Boolean Load = ex.Load;
						if(Load == true) {
							response.sendRedirect("GotoViewServlet");
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
