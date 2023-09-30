package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

/*import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;*/

public class UserControllerServlet {
	

	/**
	 * 
	 */
	/*private static final long serialVersionUID = -4331680861219300600L;
	private UserDAO uDao;

	public UserControllerServlet() {
		uDao = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		for (UserDTO u : uDao.getUserList()) {
			out.write(u.toString());
		}
	//	out.write("Bienvenido careverga");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = uDao.validate(new UserDTO(username, password));
		PrintWriter out = resp.getWriter();
		log(username);
		log(password);
		
		if (status) {
	//		out.write("Usuario encontrado!");
			RequestDispatcher rd = req.getRequestDispatcher("login-success.jsp");
			rd.forward(req, resp);
		} else {
		//	out.write("Nombre de usuario o contraseña incorrectos!");
			RequestDispatcher rd = req.getRequestDispatcher("login-error.jsp");
			rd.forward(req, resp);
		}
		out.close();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	/*	resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = uDao.validate(new UserDTO(username, password));
		PrintWriter out = resp.getWriter();
		log(username);
		log(password);
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doDelete(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doOptions(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doTrace(req, resp);
	}*/

}
