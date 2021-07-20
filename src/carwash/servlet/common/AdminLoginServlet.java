package carwash.servlet.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import carwash.dao.UserDao;
import carwash.model.User;

@WebServlet("/loginadmin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;
	
	public void init() {
		UserDao = new UserDao();
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
		User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
        	  Cookie c2 = new Cookie("LoginAdmin",username);
              c2.setMaxAge(100000);
              response.addCookie(c2);
          response.addCookie(c2);
            System.out.println("Cookie set For Admin");
            System.out.println(c2);
        	
        	
        	
            if (UserDao.validateAdmin(user)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("userlist");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
             response.sendRedirect("new-admin");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}