
<%@page import="com.constants.EEDRServerMessages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="java.util.List"%>
<%@page
	import="com.dropsapppro.response.AJAXResponse,java.util.List,com.dropsapppro.response.ErrorMessagesObj"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.css">
<script
	src="<%=request.getContextPath()%>/frameworkjs/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/frameworkjs/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/customermenu.jsp"></jsp:include>
<h1>This is Failure Page</h1>
<div style="height:20px;"></div>

	<%
		AJAXResponse ajax = (AJAXResponse) request.getAttribute(EEDRServerMessages.Keys.OBJ);
	
	
		if (null == ajax) {

		} else {
			List<ErrorMessagesObj> ebErrors = ajax.getErrMessages();

			if (null == ebErrors) {

			} else {
				
				
				ErrorMessagesObj msg = ebErrors.get(0);
	%>
	<div class="container">
		<div class="col-xs-12">
			<div class="alert alert-danger">
				<%=msg.getErrMessage()%>
			</div>
		</div>
	</div>
	<%
		}
		}
	%>



</body>
</html>