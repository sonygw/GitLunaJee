<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta charset="UTF-8">
<title>Projet Luna Jee - Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=yes">

<!-- <link href="https://fonts.googleapis.com/css?family=Rokkitt" rel="stylesheet">  -->
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet"> 	

<link rel="stylesheet" href="css/style.css">


</head>

<body>

	<div class="cont" style="background-image: url(images/pleine-lune.jpg)">
		<div class="demo">
			<div class="login">
				<!--       <div class="login__check"></div> -->
				<div
					style="height: 200px; font-size: 65px; border-style: solid; border-width: 50px; border-color: transparent;">
					<center>Luna</center>
				</div>
				<s:form action="connecter">
					<div class="login__row">
						<s:textfield name="username" id="username" label="Identifiant"
							labelposition="top" class="login__input name"></s:textfield>
						<s:password name="password" id="password" label="Mot de passe"
							labelposition="top" class="login__input pass"></s:password>
					</div>
					<div style="align-content: right 100%;">
						<s:submit type="button" class="login__submit">Connexion</s:submit>
					</div>
				</s:form>
			</div>
		</div>

	</div>

	




</body>

</html>
