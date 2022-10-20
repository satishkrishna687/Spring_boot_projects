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
	src="<%=request.getContextPath()%>/cloudsimcustom/downloadcomparegraph.js"></script>

<style>
#keyContainer1 {
   width: 80%;
    border: 1px solid blue;
    padding: 2px;
    background: yellow;
    float: left;
    margin-left: 100px;
    text-align: center;
    margin-top: 10px;
    margin-bottom: 10px;
 }

#keyContainer2 {
	 width: 80%;
    border: 1px solid blue;
    padding: 2px;
    background: pink;
    float: left;
    margin-left: 100px;
    text-align: center;
      margin-top: 10px;
    margin-bottom: 10px;
}

#keyContainer3 {
	 width: 80%;
    border: 1px solid blue;
    padding: 2px;
    background: aliceblue;
    float: left;
    margin-left: 100px;
    text-align: center;
         margin-top: 10px;
    margin-bottom: 10px;
}

#keyContainer4 {
	 width: 80%;
    border: 1px solid blue;
    padding: 2px;
    background: aqua;
    float: left;
    margin-left: 100px;
    text-align: center;
         margin-top: 10px;
    margin-bottom: 10px;
}
</style>

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/adminmenu.jsp"></jsp:include>
	<h1>Performance Download Time</h1>
	<div id="confirmationMessage"></div>
	<div id="content">


		<div id="keyContainer1"></div>

		<div id="keyContainer2"></div>

		<div id="keyContainer3"></div>
		<div id="keyContainer4"></div>

	</div>
</body>
</html>