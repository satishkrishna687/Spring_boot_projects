<%@page import="com.routingtopology.value.ECentralityRouteInfo"%>
<%@page import="com.routingtopology.value.ClosenessCentralityRouteInfo"%>
<%@page import="com.routingtopology.value.BetweenCentralityRouteInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.routingtopology.value.OptimizedRouteInfo"%>
<%@page import="com.routingtopology.value.ClosenessCentralityCriteria"%>
<%@page import="com.routingtopology.value.BetweenCentralityCriteria"%>
<%@page import="com.model.CompareOptimizedInfo"%>
<%@page import="com.routingtopology.value.RouteInfo"%>
<%@page import="com.constants.EEDRServerMessages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.routingtopology.value.RandomRouteInfo"%><html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.css">
<script src="<%=request.getContextPath()%>/frameworkjs/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/routing.css">

<style>
.input-data {
	color: black;
	font-weight: bold;
	font-size: 15px;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/customermenu.jsp"></jsp:include>

	<h2>Between Centrality Results</h2>

	<div>

		<div class="col-xs-12">


			<%
				CompareOptimizedInfo compareOptimizedInfoRoute = (CompareOptimizedInfo) request
						.getAttribute(EEDRServerMessages.MODEL_ROUTEOUT_NAME);

				if (compareOptimizedInfoRoute.getExceptionDetail() != null) {
					String errMsg = compareOptimizedInfoRoute.getExceptionDetail();
			%>
			<div class="alert alert-danger"><%=errMsg%></div>
			<%
				} else {

					BetweenCentralityRouteInfo betweenCentralityRouteInfo = compareOptimizedInfoRoute
							.getBetweenCentralityRouteInfo();

					if (null == betweenCentralityRouteInfo) {
			%>

			<div class="alert alert-danger">Could not Find Between
				Centrality Route Information.Routes could not be Found at this Point
				of Time</div>

			<%
				} else {

						List<RouteInfo> betweenCentralityRouteInfoList = betweenCentralityRouteInfo.getRouteInfoList();

						if (null == betweenCentralityRouteInfoList) {
			%>
			<div class="alert alert-danger">Could not Find Between
				Centrality Information could not be Found at this Point of Time</div>
			<%
				} else {
			%>
		</div>
	</div>
	<div>

		<!-- All Routes Start Between Centrality -->
		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Information Between Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2">T-Color Path No</div>
						<div class="col-sm-10">T-Color Nodes</div>
					</div>
					<%
						int i = 0;
									for (RouteInfo routeTemp : betweenCentralityRouteInfoList) {
										i = i + 1;
					%>
					<div class="row">
						<div class="col-sm-2 input-data"><%=i%></div>
						<div class="col-sm-10 route-info input-data">
							<%
								List<Integer> routeNodes = routeTemp.getRouteList();

												for (Integer nodeId : routeNodes) {
							%>
							<%=nodeId%>------>
							<%
								}
							%>
						</div>
					</div>
					<%
						}
								}
							}
					%>

				</div>
			</div>
		</div>
		<!-- End All Routes Between Centrality -->

		<!--  Start of Best Route Display Between Centrality -->


		<%
			if (betweenCentralityRouteInfo.getBestRoueInfo() != null) {
		%>
		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Best Path Between Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-10">Best T-Color</div>
						<div class="col-sm-2">Best Distance</div>
					</div>
					<div class="row">
						<div class="col-sm-10 route-info input-data">
							<%
								RouteInfo bestRouteBetweenCentrality = betweenCentralityRouteInfo.getBestRoueInfo();

										if (bestRouteBetweenCentrality != null) {

											List<Integer> bestRoute = bestRouteBetweenCentrality.getRouteList();

											if (bestRoute != null) {

												for (Integer nodeId : bestRoute) {
							%>
							<%=nodeId%>------>
							<%
								}

											}

										}
							%>
						</div>
						<div class="col-sm-2 input-data">
							<%=betweenCentralityRouteInfo.getBestBetweenCentrality()%>
						</div>

						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>




		<!--  End of Best Route Display Between Centrality -->

		<!-- Performance Between Centrality -->

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Performance Between Centrality</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Time Taken (ms)</th>
							<th>Total Hops</th>
							<th>Energy Consumed</th>
							<th>No Of Alive Nodes</th>
							<th>No Of Dead Nodes</th>
							<th>Lifetime Ratio</th>
							<th>Remaining Energy</th>
							<th>Routing Overhead</th>
							<th>Throughput</th>
						</tr>
					</thead>
					<tbody>
						<tr class="sucess input-data">
							<td><%=betweenCentralityRouteInfo.getTimeTaken()%></td>
							<td><%=betweenCentralityRouteInfo.getNoOfHopsConsumed()%></td>
							<td><%=betweenCentralityRouteInfo.getEnergyConsumed()%></td>
							<td><%=betweenCentralityRouteInfo.getNoOfAliveNodes()%></td>
							<td><%=betweenCentralityRouteInfo.getNoOfDeadNodes()%></td>
							<td><%=betweenCentralityRouteInfo.getLifeTimeRatio()%></td>
							<td><%=betweenCentralityRouteInfo.getResidualEnergy()%></td>
							<td><%=betweenCentralityRouteInfo.getRoutingOverhead()%></td>
							<td><%=betweenCentralityRouteInfo.getThroughput()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- End of Performance Between Centrality -->




		<!--  End of Between Centrality Complete Algorithm -->


		<!--  Start of Closeness Centrality -->
		<h2>Closeness Centrality Results</h2>
		<%
			ClosenessCentralityRouteInfo closenessCentralityRouteInfo = compareOptimizedInfoRoute
						.getClonessCentralityRouteInfo();
				if (null == closenessCentralityRouteInfo) {
		%>

		<div class="alert alert-danger">Could not Find Closeness
			Centrality Route Information.Routes could not be Found at this Point
			of Time</div>

		<%
			} else {

					List<RouteInfo> closenessCentralityRouteInfoList = closenessCentralityRouteInfo.getRouteInfoList();

					if (null == closenessCentralityRouteInfoList) {
		%>
		<div class="alert alert-danger">Could not Find Closeness
			Centrality Route Information.Routes could not be Found at this Point
			of Time</div>
		<%
			} else {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Information Closeness Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2">T-Color Path No</div>
						<div class="col-sm-10">Path</div>
					</div>


					<%
						int i = 0;
									for (RouteInfo routeTemp : closenessCentralityRouteInfoList) {
										i = i + 1;
					%>
					<div class="row">
						<div class="col-sm-2 input-data"><%=i%></div>
						<div class="col-sm-10 route-info input-data">
							<%
								List<Integer> routeNodes = routeTemp.getRouteList();

												for (Integer nodeId : routeNodes) {
							%>
							<%=nodeId%>------>
							<%
								}
							%>

						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>


		<%
			if (closenessCentralityRouteInfo.getBestRoueInfo() != null) {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Best Path Closeness Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-10">Best T-Color Route</div>
						<div class="col-sm-2">Best Distance</div>
					</div>
					<div class="row">
						<div class="col-sm-10 route-info input-data">
							<%
								RouteInfo bestRouteClosenessCentrality = closenessCentralityRouteInfo.getBestRoueInfo();

												if (bestRouteClosenessCentrality != null) {

													List<Integer> bestRoute = bestRouteClosenessCentrality.getRouteList();

													if (bestRoute != null) {

														for (Integer nodeId : bestRoute) {
							%>
							<%=nodeId%>------>
							<%
								}

													}

												}
							%>
						</div>
						<div class="col-sm-2 input-data">

							<%=closenessCentralityRouteInfo.getBestDistance()%>
						</div>

						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Performance Closeness Centrality</div>
				<div class="panel-body">
					<div class="row">

						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Time Taken (ms)</th>
									<th>Total Hops</th>
									<th>Energy Consumed</th>
									<th>No Of Alive Nodes</th>
									<th>No Of Dead Nodes</th>
									<th>Lifetime Ratio</th>
									<th>Remaining Energy</th>
									<th>Routing Overhead</th>
									<th>Throughput</th>
								</tr>
							</thead>

							<tbody>
								<tr class="sucess input-data">

									<td><%=closenessCentralityRouteInfo.getTimeTaken()%></td>
									<td><%=closenessCentralityRouteInfo.getNoOfHopsConsumed()%></td>
									<td><%=closenessCentralityRouteInfo.getEnergyConsumed()%></td>
									<td><%=closenessCentralityRouteInfo.getNoOfAliveNodes()%></td>
									<td><%=closenessCentralityRouteInfo.getNoOfDeadNodes()%></td>
									<td><%=closenessCentralityRouteInfo.getLifeTimeRatio()%></td>
									<td><%=closenessCentralityRouteInfo.getResidualEnergy()%></td>
									<td><%=closenessCentralityRouteInfo.getRoutingOverhead()%></td>
									<td><%=closenessCentralityRouteInfo.getThroughput()%></td>
								</tr>

							</tbody>


						</table>

					</div>
				</div>
			</div>
		</div>


		<%
			}
				}
		%>


		<!--  End of Closeness Centrality -->


		<!-- Start of E Centrality -->

		<%
			ECentralityRouteInfo eCentralityRouteInfo = compareOptimizedInfoRoute.geteCentralityRouteInfo();
				if (null == eCentralityRouteInfo) {
		%>

		<div class="alert alert-danger">Could not Find E-Centrality
			Route Information.Routes could not be Found at this Point of Time</div>

		<%
			} else {

					List<RouteInfo> eCentralityRouteInfoList = eCentralityRouteInfo.getRouteInfoList();

					if (null == eCentralityRouteInfoList) {
		%>
		<div class="alert alert-danger">Could not Find E Centrality
			Route Information.Routes could not be Found at this Point of Time</div>
		<%
			} else {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Information E Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2">T-Color No</div>
						<div class="col-sm-10">Route</div>
					</div>


					<%
						int i = 0;
									for (RouteInfo routeTemp : eCentralityRouteInfoList) {
										i = i + 1;
					%>
					<div class="row">
						<div class="col-sm-2 input-data"><%=i%></div>
						<div class="col-sm-10 route-info input-data">
							<%
								List<Integer> routeNodes = routeTemp.getRouteList();

												for (Integer nodeId : routeNodes) {
							%>
							<%=nodeId%>------>
							<%
								}
							%>

						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>


		<%
			if (eCentralityRouteInfo.getBestRoueInfo() != null) {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Best T-Color E Centrality</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-10">Best T-Color Path</div>
						<div class="col-sm-2">Best Distance</div>
					</div>
					<div class="row">
						<div class="col-sm-10 route-info input-data">
							<%
								RouteInfo bestECentralityRouteInfoCentrality = eCentralityRouteInfo.getBestRoueInfo();

												if (bestECentralityRouteInfoCentrality != null) {

													List<Integer> bestRoute = bestECentralityRouteInfoCentrality.getRouteList();

													if (bestRoute != null) {

														for (Integer nodeId : bestRoute) {
							%>
							<%=nodeId%>------>
							<%
								}

													}

												}
							%>
						</div>
						<div class="col-sm-2 input-data">

							<%=eCentralityRouteInfo.getDistanceEcentrality()%>
						</div>

						<%
							}
						%>

					</div>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Performance E-Centrality</div>
				<div class="panel-body">
					<div class="row">

						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Time Taken (ms)</th>
									<th>Total Hops</th>
									<th>Energy Consumed</th>
									<th>No Of Alive Nodes</th>
									<th>No Of Dead Nodes</th>
									<th>Lifetime Ratio</th>
									<th>Remaining Energy</th>
									<th>Routing Overhead</th>
									<th>Throughput</th>
								</tr>
							</thead>

							<tbody>
								<tr class="sucess input-data">

									<td><%=eCentralityRouteInfo.getTimeTaken()%></td>
									<td><%=eCentralityRouteInfo.getNoOfHopsConsumed()%></td>
									<td><%=eCentralityRouteInfo.getEnergyConsumed()%></td>
									<td><%=eCentralityRouteInfo.getNoOfAliveNodes()%></td>
									<td><%=eCentralityRouteInfo.getNoOfDeadNodes()%></td>
									<td><%=eCentralityRouteInfo.getLifeTimeRatio()%></td>
									<td><%=eCentralityRouteInfo.getResidualEnergy()%></td>
									<td><%=eCentralityRouteInfo.getRoutingOverhead()%></td>
									<td><%=eCentralityRouteInfo.getThroughput()%></td>
								</tr>

							</tbody>


						</table>

					</div>
				</div>
			</div>
		</div>


		<%
			}
				}
		%>





		<!-- End of E Centrality -->

		<!-- Start of the Optimized Route -->

		<%
			OptimizedRouteInfo optimizedRouteInfo = compareOptimizedInfoRoute.getOptimizedRouteInfo();
				if (null == optimizedRouteInfo) {
		%>

		<div class="alert alert-danger">Could not Find Optimized Route
			Information.Routes could not be Found at this Point of Time</div>

		<%
			} else {

					List<RouteInfo> optimizedRouteInfoList = optimizedRouteInfo.getRouteInfoList();

					if (null == optimizedRouteInfoList) {
		%>
		<div class="alert alert-danger">Could not Find Optimized Route
			Information.Routes could not be Found at this Point of Time</div>
		<%
			} else {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Information Optimized</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-2">Path</div>
						<div class="col-sm-10 ">Route</div>
					</div>

					<%
						int i = 0;
									for (RouteInfo routeTemp : optimizedRouteInfoList) {
										i = i + 1;
					%>
					<div class="row">
						<div class="col-sm-2"><%=i%></div>
						<div class="col-sm-10 route-info">

							<%
								List<Integer> routeNodes = routeTemp.getRouteList();

												for (Integer nodeId : routeNodes) {
							%>
							<%=nodeId%>------>
							<%
								}
							%>
						</div>
					</div>
					<%
						}
					%>

				</div>
			</div>
		</div>



		<%
			if (optimizedRouteInfo.getBestRoueInfo() != null) {
		%>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Best Information -Optimized</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-10 ">Best Route</div>
						<div class="col-sm-2">Best CQI</div>
					</div>
					<div class="row">
						<div class="col-sm-10 route-info input-data">
							<%
								RouteInfo bestRouteOptimized = optimizedRouteInfo.getBestRoueInfo();

												if (bestRouteOptimized != null) {

													List<Integer> bestRoute = bestRouteOptimized.getRouteList();

													if (bestRoute != null) {

														for (Integer nodeId : bestRoute) {
							%>
							<%=nodeId%>------>
							<%
								}

													}

												}
							%>
						</div>
						<div class="col-sm-2 input-data">
							<%=optimizedRouteInfo.getBestRouteCQI()%>
						</div>

						<%
							}
						%>

					</div>

				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">Performance Optimized</div>
				<div class="panel-body">
					<div class="row">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Time Taken (ms)</th>
									<th>Total Hops</th>
									<th>Energy Consumed</th>
									<th>No Of Alive Nodes</th>
									<th>No Of Dead Nodes</th>
									<th>Lifetime Ratio</th>
									<th>Remaining Energy</th>
									<th>Routing Overhead</th>
									<th>Throughput</th>
								</tr>
							</thead>
							<tbody>
								<tr class="success input-data">
									<td><%=optimizedRouteInfo.getTimeTaken()%></td>
									<td><%=optimizedRouteInfo.getNoOfHopsConsumed()%></td>
									<td><%=optimizedRouteInfo.getEnergyConsumed()%></td>
									<td><%=optimizedRouteInfo.getNoOfAliveNodes()%></td>
									<td><%=optimizedRouteInfo.getNoOfDeadNodes()%></td>
									<td><%=optimizedRouteInfo.getLifeTimeRatio()%></td>
									<td><%=optimizedRouteInfo.getResidualEnergy()%></td>
									<td><%=optimizedRouteInfo.getRoutingOverhead()%></td>
									<td><%=optimizedRouteInfo.getThroughput()%></td>
								</tr>
							</tbody>
						</table>



						<%
							}

								}
						%>


					</div>
				</div>
			</div>
		</div>

		<!-- End of Optimized  Performance -->


		<!-- End of the Optimized Route -->
		<%
			}
		%>

	</div>


</body>
</html>