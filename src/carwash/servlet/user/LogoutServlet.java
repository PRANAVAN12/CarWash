package carwash.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carwash.dao.UserDao;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;

	public void init() {
		UserDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("Hiiii");
		Cookie c1 = new Cookie("LoginUser", "");
		c1.setMaxAge(100000);
		response.addCookie(c1);
		response.addCookie(c1);
		System.out.println("Cookie set For User");
		System.out.println(c1);

		response.sendRedirect("index.jsp");

	}
}