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

	<h1 style="text-align: center; margin-top:0px ; position:relative">BIENVENUE ${client.prenom}</h1>
	<br>

	<div style="overflow: auto">

		<s:a action="affTabCli" theme="simple" style="margin-right:5rem"
			title="Clients">
			<img src="images/accueil/customer.ico">
		</s:a>

		<s:a action="affTabArt" theme="simple" style="margin-right:3rem"
			title="Articles">
			<img src="images/accueil/commandes.ico">
		</s:a>

		<s:a action="affTabCom" theme="simple" style="margin-right:3rem"
			title="Commandes">
			<img src="images/accueil/cart.ico">
		</s:a>

		<s:a action="affTabPan" theme="simple" style="float:right"
			title="Panier">
			<img src="images/panier.ico">
		</s:a>
	</div>

</body>
</html>