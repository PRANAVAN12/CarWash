package carwash.servlet.booking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carwash.dao.BookingDao;
import carwash.model.Booking;



@WebServlet("/update-booking")
public class BookingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookingDao BookingDao;
	
	public void init() {
		BookingDao = new BookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("user");
		String email = request.getParameter("email");
		String carpack = request.getParameter("carpack");
	
		String bookingdate = (request.getParameter("bookingdate"));
		String status = (request.getParameter("status"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		System.out.println("id   :"+id);
		
		Booking Booking = new Booking(  id,user, email, carpack, bookingdate, status, amount);
		
		
		System.out.println(Booking);
		try {
			BookingDao.updateRooms(Booking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list-bookings");
	}

	

}