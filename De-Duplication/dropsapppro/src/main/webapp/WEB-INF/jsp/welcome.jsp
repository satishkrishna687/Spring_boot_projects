<!DOCTYPE html>
<html class="no-js">
<!--<![endif]-->
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.css">
<script
	src="<%=request.getContextPath()%>/frameworkjs/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.js"></script>
<style>
.productBtn {
	color: #fff !important;
	background-color: #4CAF50 !important;
	padding: 8px 16px;
	float: left;
	width: auto;
	border: none;
	display: block;
	outline: 0;
}
</style>

</head>

<body>

	<div class="container" id="contentContainer">

		<div class="row">

			<!-- First Column Division -->

			<div class="col-lg-6 col-md-6 col-xs-12 col-sm-12">

				<!-- Panel Start -->
				<div class="panel panel-primary">

					<div class="panel-heading">Login User</div>
					<div class="panel-body">

						<div>
							<h1>Login for All</h1>
						</div>

						<div>

							<a href="<%=request.getContextPath()%>/loginUser"
								class="btn btn-primary">Login</a>
						</div>

					</div>
				</div>
				<!-- Panel End -->



			</div>

			<!-- First Column Division  End-->



			<!-- Thrid Column Division -->

			<div class="col-lg-6 col-md-6 col-xs-12 col-sm-12">

				<!-- Panel Start -->
				<div class="panel panel-primary">

					<div class="panel-heading">Register User</div>
					<div class="panel-body">

						<div>
							<h1>Registration for Customers</h1>
						</div>

						<div>
							<a href="<%=request.getContextPath()%>/registerCustomerPage"
								class="btn btn-primary">Sign Up user</a>
						</div>

					</div>
				</div>
				<!-- Panel End -->



			</div>

			<!-- Thrid Column Division  End-->



		</div>

	</div>

</body>

</html>