<!DOCTYPE html>
<html>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>


<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>

.input-data{
color:black;
font-weight:bold;
font-size: 15px;
border:3px blue solid;
}



</style>


</head>
<body>
	<jsp:include page="/WEB-INF/jsp/customermenu.jsp"></jsp:include>
	<font color="red"></font>

	<div class="container">

		<div class="col-xs-12">

			<div class="panel panel-primary">

				<div class="panel-heading">Routing Input</div>
				<div class="panel-body">

					<form class="form-horizontal" method="post"
						action="<%=request.getContextPath()%>/findRoute.do">


						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Energy
								Required For Transmission</label>
							<div class="col-sm-6">
								<select class="form-control input-data" name="energyTx">
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Att
								Factor</label>
							<div class="col-sm-6">
								<select name="attFactor" class="form-control input-data">
									<option value="0.1">0.1</option>
									<option value="0.2">0.2</option>
									<option value="0.3">0.3</option>
									<option value="0.4">0.4</option>
									<option value="0.5">0.5</option>
									<option value="0.6">0.6</option>
									<option value="0.7">0.7</option>
									<option value="0.8">0.8</option>
									<option value="0.9">0.9</option>
									<option value="1">1</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Energy
								Required For Amplification</label>
							<div class="col-sm-6">
								<select name="energyAmp" class="form-control input-data">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Source
								Node</label>
							<div class="col-sm-2">
								<input type="number" class="form-control input-data" name="sourceNode"
									size="2" maxlength="2">
							</div>
							<div class="col-sm-4"></div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Destination
								Node</label>
							<div class="col-sm-2">
								<input type="number" class="form-control input-data" name="destinationNode"
									size="2" maxlength="2">
							</div>
							<div class="col-sm-4"></div>
						</div>

						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">TTL
								of Node</label>
							<div class="col-sm-2">
								<input type="number" class="form-control input-data" name="ttl" size="2"
									maxlength="2">
							</div>
							<div class="col-sm-4"></div>
						</div>


						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Coverage
								Area</label>
							<div class="col-sm-2">
								<input type="number" class="form-control input-data" name="coverageArea"
									size="2" maxlength="2">
							</div>
							<div class="col-sm-4"></div>
						</div>



						<div class="form-group">
							<label for="inputEmail3" class="col-sm-6 control-label">Threshold
								Battery</label>
							<div class="col-sm-2">
								<input type="number" class="form-control input-data"
									name="thresholdBattery" size="2" maxlength="2">
								<div class="col-sm-4"></div>
							</div>
						</div>


						<div class="form-group">
							<label for="dataPacket" class="col-sm-6 control-label">Data Packet</label>
							<div class="col-sm-6">
								<textarea class="form-control input-data" rows="5" name="dataPacket" id="dataPacket"></textarea>
								
							</div>
						</div>
						
						<div class="form-group">
						<label for="inputEmail3" class="col-sm-6 control-label">Energy
								Data Transmission Configuration (Use Source IP)</label>
						<div class="col-sm-6">
							<select name="sameIP" class="form-control input-data">
									<option value="YES">YES</option>
									<option value="NO">NO</option>
							</select>
						</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-6 col-sm-6">
								<button type="submit" class="btn btn-primary">Route Me</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>





</html>