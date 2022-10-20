<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topology</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs41/resources/css/ext-all.css" />
<script type="text/javascript" >
var contextPath='<%=request.getContextPath()%>';
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/extjs41/ext-all-debug.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/cloudsimcustom/topologygen.js"></script>


</head>
<body background="<%=request.getContextPath()%>/jsp/images/nodedeployment.jpg">
<jsp:include page="/WEB-INF/jsp/customermenu.jsp"></jsp:include>

<div id="menuspace">
This is the page where we create  Topology
 </div>
 

<div id="content">

<div id="confirmationMessage"></div>
<div id="ErrorDiv" />
<div id="buttonDiv"/>

<div id="contentDiv" />
<div id="AddDiv" />
</div>
</body>
</html>