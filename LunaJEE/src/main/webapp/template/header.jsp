<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="monheader">

	<div>

		<s:submit value="Accueil" type="image" src="images/accueil/home64.ico" action="accueil"
			theme="simple" style="margin-right:5rem"></s:submit>
		<s:submit value="Client" type="image"
			src="images/accueil/customer.ico" theme="simple"
			style="margin-right:3rem"></s:submit>
		<s:submit value="Articles" type="image"
			src="images/accueil/commandes.ico" theme="simple"
			style="margin-right:3rem"></s:submit>
		<s:submit value="Commandes" type="image" src="images/accueil/cart.ico"
			theme="simple"></s:submit>
	</div>


</body>
</html>