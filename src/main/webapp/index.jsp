<%@page import="com.facebook.login.action.FBConnection"%>
<%-- <%@page import= "com.OauthExample.action.GoogleConnection" %> --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<h2>Hello World!</h2>
<%FBConnection fbConnection= new FBConnection(); %>

<h1>Login page</h1>
	
	<a href="<%=fbConnection.getFBAuthUrl()%>"> login with fb
			
		</a>
</body>
</html>
