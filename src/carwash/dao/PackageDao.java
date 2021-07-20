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
import carwash.model.Package;

public class PackageDao {

	// rooms
	private static final String INSERT_rooms_SQL = "INSERT INTO carpackage" + " ( name,description,cost) VALUES "
			+ " ( ?,?,?);";

	private static final String SELECT_rooms_BY_ID = "select id,name,description,cost from carpackage where id =?";
	private static final String SELECT_ALL_erooms = "select * from carpackage";
	private static final String DELETE_rooms_SQL = "delete from carpackage where id = ?;";
	private static final String UPDATE_rooms_SQL = "update carpackage set name = ?,  description = ?,cost = ?  where id = ?;";

	public PackageDao() {
	}

	DbConnection dbconnection = new DbConnection();

// insert Rooms
	public void insertRooms(Package room) throws SQLException {
		System.out.println(INSERT_rooms_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_rooms_SQL)) {
			preparedStatement.setString(1, room.getName());
			preparedStatement.setString(2, room.getDescription());

			preparedStatement.setInt(3, room.getCost());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
	}

	// select Room
	public Package selectRoom(int id) {
		Package room = null;
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

				String name = rs.getString("name");
				String description = rs.getString("description");
				int cost = rs.getInt("cost");

				room = new Package(id, name, description, cost);
			}

		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return room;
	}

	// select All Rooms
	public List<Package> selectAllRooms() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Package> rooms = new ArrayList<>();
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
				String name = rs.getString("name");
				String description = rs.getString("description");
				int cost = rs.getInt("cost");

				rooms.add(new Package(id, name, description, cost));
			}
		} catch (SQLException e) {
			dbconnection.printSQLException(e);
		}
		return rooms;
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
	public boolean updateRooms(Package room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = dbconnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_rooms_SQL);) {
			statement.setString(1, room.getName());
			statement.setString(2, room.getDescription());

			statement.setInt(3, room.getCost());
			statement.setInt(4, room.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}