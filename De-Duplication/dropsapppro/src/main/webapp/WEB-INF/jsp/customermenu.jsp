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
				href="<%=request.getContextPath()%>/customerNavHomePage"><span>Customer</span></a></li>
			<li>
			<li class='has-sub '><a href='#'>Topology<span></span></a>
				<ul>
					<li class='active '><a
						href="<%=request.getContextPath()%>/settingsNav"><span>Settings</span></a></li>
					<li class='active '><a
						href="<%=request.getContextPath()%>/cleanUpNav"><span>Data
								Clean Up</span></a></li>

					<li><a href='<%=request.getContextPath()%>/edfTopologyNav'><span>Create
								Topology</span></a></li>
					<li><a href='<%=request.getContextPath()%>/viewTopologyEdfNav'><span>View
								Topology</span></a></li>
				</ul></li>


			<li class='has-sub '><a href='#'><span>Distance
						Tables</span></a>
				<ul>

					<li><a
						href='<%=request.getContextPath()%>/createroutingtables.do'><span>Generate
								Distance Tables</span></a></li>

					<li><a
						href='<%=request.getContextPath()%>/navViewroutingtablepage'><span>View
								Distance Tables</span></a></li>
				</ul></li>

			<li class='has-sub '><a href='#'><span> Energy
						Intialization/Update</span></a>
				<ul>

					<li><a
						href='<%=request.getContextPath()%>/closenessCentralityGeneration.do'><span>Generate Closeness
								</span></a></li>

					<li><a
						href='<%=request.getContextPath()%>/navClosenessCentralityEnergy'><span>View
								Closeness</span></a></li>

					<li><a
						href='<%=request.getContextPath()%>/betweenCentralityGenerate.do'><span>Generate Between
								</span></a></li>
					<li><a
						href='<%=request.getContextPath()%>/navViewenergytablesbetweencentrality'><span>View
								Between</span></a></li>
					<li><a
						href='<%=request.getContextPath()%>/eCentralityGenerate.do'><span>Generate
								E-Centrality</span></a></li>
					<li><a
						href='<%=request.getContextPath()%>/navViewenergytablesEcentrality'><span>View
								E-Centrality</span></a></li>
					<li><a
						href='<%=request.getContextPath()%>/createenergytableoptimized.do'><span>Generate
								Optimized</span></a></li>

					<li><a
						href='<%=request.getContextPath()%>/navViewenergytablepage'><span>View
								Optimized </span></a></li>
				</ul></li>



			<li class='has-sub '><a href='#'><span>Routing
						Process </span></a>
				<ul>
					<li><a href='<%=request.getContextPath()%>/navRouting'><span>Route
								Discovery</span></a></li>
				</ul>
			</li>
				
			<li class='has-sub '><a href='#'><span>View Files</span></a>
				<ul>
					<li><a
						href='<%=request.getContextPath()%>/navViewCustomerFileChunks'><span>View
								File Chunks</span></a></li>
					
					<li><a
						href='<%=request.getContextPath()%>/navViewCustomerFileReplica'><span>View
								File Replicas</span></a></li>
								
					<li><a
						href='<%=request.getContextPath()%>/navViewCustomerFiles'><span>View
								Customer Files</span></a></li>					
								
				</ul>
			</li>
				
			
			<li class='has-sub '><a href='#'><span>Routing
						History </span></a>
				<ul>
					<li><a href='<%=request.getContextPath()%>/navCustRouteHistory'><span>History
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