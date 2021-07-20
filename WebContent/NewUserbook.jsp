<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Booking Confirmation</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="Book/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="Book/css/style.css">
</head>
<body>

	<div class="main">

		<div class="container">
			<form action="insert-user-booking" method="post" class="appointment-form" id="appointment-form">
				<h2>Booking Confirmation form</h2>
				<div class="form-group-1">
					<input type="text" name="carpack" id="title"
						placeholder="Package Name" value=" ${pack.name}"  readonly="readonly"/>
						<p>User</p><input type="text" name="user" id="name" placeholder="Your Name" value="${user}" readonly="readonly"/>

						<input type="email" name="email" id="email" placeholder="Contact Email"  />
						<input type="text" name="bookingdate"  placeholder="Booking Date" value="${datebook}" readonly="readonly"   />
						<input type="text" name="amount" id="phone_number" placeholder="Amount" value="${pack.cost}" readonly="readonly" />
						<div class="form-check">
                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                    <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree to the  <a href="#" class="term-service">Terms and Conditions</a></label>
                </div>
						<div class="form-submit">
                    <input type="submit"  id="submit" class="submit" value="Confirm a Tour" />
                </div>
			</form>
		</div>

	</div>

	<!-- JS -->
	<script src="Book/vendor/jquery/jquery.min.js"></script>
	<script src="Book/js/main.js"></script>
</body>
</html>