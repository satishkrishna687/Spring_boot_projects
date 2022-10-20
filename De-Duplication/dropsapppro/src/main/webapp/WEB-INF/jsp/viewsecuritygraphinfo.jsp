<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Energy Panel</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/extjs41/resources/css/ext-all.css" />
<script type="text/javascript">
var contextPath='<%=request.getContextPath()%>';
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/extjs41/bootstrap.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/cloudsimcustom/viewsecuritygraphinfo.js"></script>

<style>
#keyContainer1 {
	width: 50%;
	border: 1px solid blue;
	padding: 2px;
	background: yellow;
	float: left;
	margin-left: 10px;
}

#allContainer {
	width: 50%;
	border: 1px solid blue;
	padding: 2px;
	background: pink;
	margin-left: 700px;
	margin-right: 10px;
}

#allContainer1 {
	width: 50%;
	border: 1px solid blue;
	padding: 2px;
	background: aliceblue;
	margin-top: 10px;
	margin-left: 10px;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/adminmenu.jsp"></jsp:include>
	<h1>Performance Security Measure</h1>
	<div id="confirmationMessage"></div>
	<div id="content">


		<div id="keyContainer1"></div>

		<div id="allContainer"></div>

		<div id="allContainer1"></div>
		<div id="allContainer2"></div>

	</div>
</body>
</html>