<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'un Client</title>
</head>
<body>

	<fieldset>
		<legend>Ajout d'un client</legend>
		<s:form method="post" action="createCli">
			<div>
				<s:textfield class="textFieldPerso" label="Nom" name="nom" required="true"
					labelposition="left" />
				<s:textfield class="textFieldPerso" label="Prenom" name="prenom" required="true"
					labelposition="left" />

				<s:textfield class="textFieldPerso" label="Email" name="email" type="email" required="true"
					labelposition="left" />
				
				<s:textfield class="textFieldPerso" label="Telephone" size="10" name="numeroTelephone" type="number"
					required="true" labelposition="left" />

				<s:textfield class="textFieldPerso" label="Adresse" name="adresse" required="true"
					labelposition="left" />

				<s:textfield class="textFieldPerso" label="Login" name="client.login" required="true"
					labelposition="left" />

				<s:password class="textFieldPerso" label="Mot de passe" name="client.motDePasse"
					required="true" labelposition="left" />
					
					<s:textfield class="textFieldPerso" label="remarques" name="remarques" 
					labelposition="left" />

			</div>
			<s:radio label="Carte de fidélité" labelposition="left"
				id="radiobutton" name="carteFidelite"
				list="#{'true' : 'oui', 'false' : 'non'}" />

			<s:submit class="ButtPerso" value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>