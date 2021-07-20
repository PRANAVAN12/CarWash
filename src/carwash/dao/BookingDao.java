package carwash.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carwash.dbconncetion.DbConnection;
import carwash.model.Booking;

public class BookingDao {

	// rooms
	private static final String INSERT_rooms_SQL = "INSERT INTO booking"
			+ " ( user,email,package,bookingdate,Amount) VALUES " + " ( ?,?,?,?,?);";
	private static final String SELECT_ALL_BookingbyUser = "select * from booking where user=? ";
	private static final String SELECT_rooms_BY_ID = "select id,user,email,package,bookingdate,status,Amount from booking where id =?";
	private static final String SELECT_ALL_erooms = "select * from booking";
	private static final String DELETE_rooms_SQL = "delete from booking where id = ?;";
	private static final String UPDATE_rooms_SQL = "update booking set user = ?,email = ?,package = ?,bookingdate = ?,status = ?,Amount = ?  where id = ?;";
	private static final String UPDATE_cancel_SQL = "update booking set status = ?  where id = ?;";

	public BookingDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Rooms
	public void insertRooms(Booking Booking) throws SQLException {
		System.out.println(INSERT_rooms_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_rooms_SQL)) {
			preparedStatement.setString(1, Booking.getUser());
			preparedStatement.setString(2, Booking.getEmail());

			preparedStatement.setString(3, Booking.getCarpack());

			preparedStatement.setString(4, Booking.getBookingdate());
			preparedStatement.setInt(5, Booking.getAmount());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// insertuser Rooms
	public void insertuserRooms(Booking Booking) throws SQLException {
		System.out.println(INSERT_rooms_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_rooms_SQL)) {
			preparedStatement.setString(1, Booking.getUser());
			preparedStatement.setString(2, Booking.getEmail());

			preparedStatement.setString(3, Booking.getCarpack());

			preparedStatement.setString(4, Booking.getBookingdate());
			preparedStatement.setInt(5, Booking.getAmount());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Room
	public Booking selectRoom(int id) {
		Booking Booking = null;
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_rooms_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String user = rs.getString("user");
				String email = rs.getString("email");

				String carpack = rs.getString("package");
			
				String bookingdate = rs.getString("bookingdate");
				String status = rs.getString("status");
				int amount = rs.getInt("Amount");
				Booking = new Booking(id, user, email, carpack, bookingdate, status, amount);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return Booking;
	}

	// select All Rooms
	public List<Booking> selectAllRooms() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Booking> Booking = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_erooms);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("user");
				String email = rs.getString("email");

				String carpack = rs.getString("package");
			
				String bookingdate = rs.getString("bookingdate");
				String status = rs.getString("status");
				int amount = rs.getInt("Amount");

				Booking.add(new Booking(id, user, email, carpack, bookingdate, status, amount));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return Booking;
	}

	// select All RoomBokings
	public List<Booking> selectAllRoomBookingsByUser(String User) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Booking> Booking = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = dbconnection.getConnection();

				// Step 2:Create a statement using connection object

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BookingbyUser);) {
			preparedStatement.setString(1, User);

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println("id-------------" + id);
				String user = rs.getString("user");
				System.out.println("user-------------" + user);
				String email = rs.getString("email");
				System.out.println("email-------------" + email);
				String carpack = rs.getString("package");
				System.out.println("tourpack-------------" + carpack);
		
				String bookingdate = rs.getString("bookingdate");
				System.out.println("bookingdate-------------" + bookingdate);
				String status = rs.getString("status");
				System.out.println("status-------------" + status);
				int amount = rs.getInt("Amount");
				System.out.println("amount-------------" + amount);
				Booking.add(new Booking(id, user, email, carpack, bookingdate, status, amount));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return Booking;
	}

	// Delete rooms
	public boolean deleteRoom(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_rooms_SQL);) {

			statement.setInt(1, id);
			System.out.println(statement);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// Update Room
	public boolean updateRooms(Booking Booking) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_rooms_SQL);) {

			statement.setString(1, Booking.getUser());
			statement.setString(2, Booking.getEmail());
	
			statement.setString(3, Booking.getCarpack());
			
			statement.setString(4, Booking.getBookingdate());
			statement.setString(5, Booking.getStatus());
			statement.setInt(6, Booking.getAmount());
			statement.setInt(7, Booking.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	// Update Room
	public boolean CancelBooking(Booking Booking) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_cancel_SQL);) {

			statement.setString(1, Booking.getStatus());
			System.out.println("status ---" + Booking.getStatus());
			statement.setInt(2, Booking.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public void insertRoomsBook(Booking booking) {
		// TODO Auto-generated method stub

	}

}