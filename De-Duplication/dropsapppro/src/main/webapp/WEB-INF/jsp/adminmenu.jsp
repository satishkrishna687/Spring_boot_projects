<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=request.getContextPath()%>/css/styles.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/customer.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id='cssmenu'>

		<ul>

			<li class='active '><a
				href="<%=request.getContextPath()%>/adminPage"><span>Home</span></a>
			</li>

			<li class='active '><a
				href="<%=request.getContextPath()%>/viewUsersPage"><span>View
						Users</span></a></li>

			<li class='has-sub '><a href='#'><span>Performance
						Table1</span></a>
				<ul>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navTimeTablePage"><span>View
								Time </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navHopTablePage"><span>View
								Hops </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navEnergyTablePage"><span>View
								Energy </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAliveTablePage"><span>View
								Alive </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navDeadTablePage"><span>View
								Dead </span></a></li>
				
				</ul></li>
				
				<li class='has-sub '><a href='#'><span>Performance
						Table2</span></a>
				<ul>
						<li class='active '><a
						href="<%=request.getContextPath()%>/navLifetimeTablePage"><span>View
								Lifetime </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navRETablePage"><span>View
								Residual Energy </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navROTablePage"><span>View
								Routing Overhead </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navThroughputTablePage"><span>View
								Throughput </span></a></li>
				</ul>
				</li>
				
				
				<li class='has-sub '><a href='#'><span>Performance
						Graphs1</span></a>
				<ul>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navTimeTableGPage"><span>View
								Time </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navHopTableGPage"><span>View
								Hops </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navEnergyTableGPage"><span>View
								Energy </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAliveTableGPage"><span>View
								Alive </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navDeadTableGPage"><span>View
								Dead </span></a></li>
				</ul></li>
				
				<li class='has-sub '><a href='#'><span>Performance
						Graphs2</span></a>
				<ul>
				<li class='active '><a
						href="<%=request.getContextPath()%>/navLifetimeTableGPage"><span>
								Lifetime </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navRETableGPage"><span>
								Residual Energy </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navROTableGPage"><span>
								Routing Overhead </span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navThroughputTableGPage"><span>
								Throughput </span></a></li>
					
				</ul>
				</li>

			<li class='has-sub '><a href='#'><span>File Views</span></a>
				<ul>
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAllFileChunks"><span>View
								File Chunks </span></a>
					</li>
					
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAllFileReplicas"><span>View
								File Replicas </span></a>
					</li>
					
						
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAllFiles"><span>View
								All Files </span></a>
					</li>
					
					<li class='active '><a
						href="<%=request.getContextPath()%>/navAllEncFiles"><span>View
								All Enc Files </span></a>
					</li>
					
					
				</ul>
			</li>
			
			<li class='has-sub '><a href='#'><span>Routing
						History </span></a>
				<ul>
					<li><a href='<%=request.getContextPath()%>/navAllRouteHistory'><span>T-Color History
								</span></a></li>
				</ul>
			</li>
			
			<li class='has-sub '><a href='#'><span>Security Performance </span></a>
				<ul>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityCompare'><span>Security Comparison
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityGraphTime'><span>Time Comparison
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityGraphMemory'><span>Memory Comparison
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityGraphBytes'><span>Bytes Comparison
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityInfoTable'><span>File Size Comparison Table
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllSecurityInfo'><span>File Size Comparison 
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllDownloadTable'><span>Download Compare Table
								</span></a></li>
					<li><a href='<%=request.getContextPath()%>/navAllDownloadGraph'><span>Download Compare Graph
								</span></a></li>
				</ul>
			</li>
			
		

			<li class='active '><a
				href="<%=request.getContextPath()%>/logout.do"><span>Logout</span></a>
			</li>

		</ul>


	</div>
</body>
</html>