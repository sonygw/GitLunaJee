<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div style="height: 200px"></div>

	<s:form action="affTabCli">
		<s:submit value="Client" type="image"
			src="images/accueil/customer.ico" theme="simple"
			style="margin-left:50%">Clients</s:submit>
	</s:form>


	<br>
	<s:form action="affTabArt">
		<s:submit value="Articles" type="image"
			src="images/accueil/commandes.ico" theme="simple"
			style="margin-left:50%">Articles</s:submit>
	</s:form>
	<br>
	<s:form action="affTabCom">
		<s:submit value="Commandes" type="image" src="images/accueil/cart.ico"
			theme="simple" style="margin-left:50%">Commandes</s:submit>
	</s:form>
</body>
</html>