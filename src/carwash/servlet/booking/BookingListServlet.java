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




@WebServlet("/list-bookings")
public class BookingListServlet extends HttpServlet {
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
		List<Booking> Booking = BookingDao.selectAllRooms();
		//System.out.print(listUser);
		request.setAttribute("listRoomBooking", Booking);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BookingList.jsp");
		dispatcher.forward(request, response);
		
	}

	

}