<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Routing Table</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs41/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/extjs41/resources/css/ext-all-gray.css" />
<script type="text/javascript" >
var contextPath='<%=request.getContextPath()%>';
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/extjs41/bootstrap.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/cloudsimcustom/viewroutingtable.js"></script>

<style>

.x-grid-cell-inner{
overflow: hidden;
    -o-text-overflow: ellipsis;
    text-overflow: ellipsis;
    padding: 2px 6px 3px;
    white-space: nowrap;
    text-align: left;
    font-size: 10px;
    font-weight: bold;

}

</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/customermenu.jsp"></jsp:include>
<div id="menuspace">
<h1>This is the page where we view Routing Tables</h1>
 </div>
 
<div id="content">

<div id="confirmationMessage" color="black" background="yellow" ></div>
<div id="ErrorDiv" />
<div id="content">
This is the topology information of the nodes
</div>
<div id="criteriaContainer"></div>
<div id="routingGridContainer"></div>
</div>
</div>
</body>
</html>