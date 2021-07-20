package carwash.servlet.user;

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

@WebServlet("/loginUser")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;
	
	public void init() {
		UserDao = new UserDao();
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String success = "t";
        String error = "Incorrect";
        String password = request.getParameter("password");
		User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
        	  Cookie c1 = new Cookie("LoginUser",username);
              c1.setMaxAge(100000);
              response.addCookie(c1);
          response.addCookie(c1);
            System.out.println("Cookie set For User");
            System.out.println(c1);
        	
            
        	
            if (UserDao.validate(user)) {
               
            	
                response.sendRedirect("list-userpackages");
            } else {
            	
            	
               
      
            	request.setAttribute("error", error);
             response.sendRedirect("login");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}