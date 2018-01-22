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

<s:a action="accueil" theme="simple" style="margin-right:5rem">
<img src="images/accueil/home64.ico"> Accueil
</s:a>

<s:a action="affTabCli" theme="simple" style="margin-right:3rem">
<img src="images/accueil/customer.ico"> Clients
</s:a>

<s:a action="affTabArt" theme="simple" style="margin-right:3rem">
<img src="images/accueil/commandes.ico"> Articles
</s:a>

<s:a action="affTabCom" theme="simple" style="margin-right:3rem">
<img src="images/accueil/cart.ico"> Commandes
</s:a>
	</div>


</body>
</html>