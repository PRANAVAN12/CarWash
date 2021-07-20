package carwash.model;

public class Booking {
	public int id;
	public String user;
	public String email;
	public String carpack;

	public String bookingdate;
	public String status;
	public int amount;

	public Booking(String user, String email, String carpack, String bookingdate, int amount) {
		super();
		this.user = user;
		this.email = email;
		this.carpack = carpack;
		this.bookingdate = bookingdate;
		this.status = status;
		this.amount = amount;
	}
	

	public Booking(String user, String email, String carpack, String bookingdate, String status, int amount) {
		super();
		this.user = user;
		this.email = email;
		this.carpack = carpack;
		this.bookingdate = bookingdate;
		this.status = status;
		this.amount = amount;
	}


	public Booking(int id, String user, String email, String carpack, String bookingdate, String status, int amount) {
		super();
		this.id = id;
		this.user = user;
		this.email = email;
		this.carpack = carpack;
		this.bookingdate = bookingdate;
		this.status = status;
		this.amount = amount;
	}

	public Booking(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCarpack() {
		return carpack;
	}

	public void setCarpack(String carpack) {
		this.carpack = carpack;
	}

	public String getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
