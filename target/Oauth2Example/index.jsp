<%@page import="com.OauthExample.action.FBConnection"%>
<%-- <%@page import= "com.OauthExample.action.GoogleConnection" %> --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<h2>Hello World!</h2>
<%FBConnection fbConnection= new FBConnection(); %>

<h1>Login page</h1>
		<s:if test="hasActionMessages()">
   
      <s:actionmessage/>
  
</s:if>
   
      <s:actionmessage/>
   
  <s:if test="hasActionErrors()">
  
      <s:actionerror/>

</s:if>

		 <s:form action="login" method="post">
 <s:textfield name="email" label="Username"></s:textfield>
 <s:password name="usn" label="Password"></s:password>
 <s:submit value="Login"><s:url action="NewUser" var="reg"></s:url><s:a href="%{reg}">Register </s:a>
 </s:submit>
 </s:form>

<%-- <%GoogleConnection gConnection=new GoogleConnection(); %> --%>
	<a href="<%=fbConnection.getFBAuthUrl()%>"> <img
			style="margin-top: 138px;" src="./images/facebookloginbutton.png" />
			 <img
			style="margin-top: 138px;" src="./images/googlebutton.png" />
		</a>
		
	<%-- <a href="<%=gConnection.getAuthURL()%>"> <img
			style="margin-top: 138px;" src="./images/googlebutton.png" />
		</a> --%>
	
			
</body>
</html>
