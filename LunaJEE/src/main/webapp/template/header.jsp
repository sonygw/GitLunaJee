<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link href="https://fonts.googleapis.com/css?family=Rokkitt" rel="stylesheet">  -->
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="monheader"
	style="background: url(images/background.jpg) no-repeat center fixed; background-size: cover;">
	
	<div style="overflow: auto">

		<s:a action="accueil" theme="simple" style="margin-right:5rem"
			title="Accueil">
			<img src="images/accueil/home64.ico">
		</s:a>

		<s:a action="affTabCli" theme="simple" style="margin-right:3rem"
			title="Client">
			<img src="images/accueil/customer.ico">
		</s:a>

		<s:a action="affTabArt" theme="simple" style="margin-right:3rem"
			title="Article">
			<img src="images/accueil/commandes.ico">
		</s:a>


		<s:a action="affTabCom" theme="simple" style="margin-right:3rem"
			title="Commande">
			<img src="images/accueil/cart.ico">
		</s:a>
		<s:a action="deconnecter" theme="simple" style="position: absolute ; left:95%"
			title="Deconnexion">
			<img src="images/logout.png">
		</s:a>
		<s:a action="affTabPan" theme="simple" style="position: absolute; left:90%"
			title="Panier">
			<img src="images/panier.ico">
		</s:a>

	</div>


</body>
</html>