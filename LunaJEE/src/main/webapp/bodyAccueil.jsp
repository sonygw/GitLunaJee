<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link href="https://fonts.googleapis.com/css?family=Rokkitt" rel="stylesheet">  -->
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body
	style="vertical-align: top; background: url(images/background.jpg) no-repeat center fixed; background-size: cover;">

	<center style="font-size: 4rem">BIENVENUE ${client.prenom}</center>
	<br>

	<div class="zoom" style="position: absolute; top :50% ; left: 50%;transform: translate(-50%, -50%);">

		

		<s:a action="affTabCli" theme="simple" 
			title="Clients">
			<img src="images/people.ico">
		</s:a>

		<s:a action="affTabArt" theme="simple" 
			title="Articles">
			<img src="images/ship.ico">
		</s:a>

		<s:a action="affTabCom" theme="simple" 
			title="Commandes">
			<img src="images/cart.ico">
		</s:a>

		<s:a action="affTabPan" theme="simple"
			title="Panier">
			<img src="images/panier_accueil.ico">
		</s:a>
	</div>

</body>
</html>