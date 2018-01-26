<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body style="vertical-align: top; background-image: url(images/fond-background-bleu.jpg)">

	<h1 style="text-align: center">BIENVENUE ${client.prenom}</h1>
	<br>

	<div style="overflow: auto ; vertical-align:middle">
	
	<div style="height:20vw"> </div>

		<s:a action="affTabCli" theme="simple" style="margin-right:5rem"
			title="Clients">
			<img src="images/people.ico">
		</s:a>

		<s:a action="affTabArt" theme="simple" style="margin-right:3rem"
			title="Articles">
			<img src="images/ship.ico">
		</s:a>

		<s:a action="affTabCom" theme="simple" style="margin-right:3rem"
			title="Commandes">
			<img src="images/cart.ico">
		</s:a>

		<s:a action="affTabPan" theme="simple" style="margin-right:3rem"
			title="Panier">
			<img src="images/panier_accueil.ico">
		</s:a>
	</div>

</body>
</html>