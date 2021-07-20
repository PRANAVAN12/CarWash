package carwash.servlet.packageD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carwash.dao.PackageDao;
import carwash.model.Package;


@WebServlet("/new-package")
public class PackageNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PackageDao packages;

	public void init() {
		packages = new PackageDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		RequestDispatcher dispatcher = request.getRequestDispatcher("NewPackage.jsp");
		dispatcher.forward(request, response);
	}

	
}