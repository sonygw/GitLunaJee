<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un client</title>
</head>
<body>
	<fieldset>
		<legend>Modification d'un Client</legend>
		<s:form method="post" action="updateCli2">
			<div>
				<s:textfield class="textFieldPerso" label="Nom" name="client.nom" labelposition="left" />
				<s:textfield class="textFieldPerso" label="Prenom" name="client.prenom" required="true"
					labelposition="left" />

				<s:textfield class="textFieldPerso" label="Email" name="client.email" required="true"
					labelposition="left" />

				<s:textfield class="textFieldPerso" label="remarques" name="client.remarques"
					required="true" labelposition="left" />

				<s:textfield class="textFieldPerso" label="Telephone" name="client.numeroTelephone"
					required="true" labelposition="left" />

				<s:textfield class="textFieldPerso" label="Adresse" name="client.adresse" required="true"
					labelposition="left" />

				<s:textfield class="textFieldPerso" label="Login" name="client.login" required="true"
					labelposition="left" />
					
				<s:password class="textFieldPerso" label="Mot de passe" name="client.motDePasse" required="true"
					labelposition="left" />


			</div>
			<s:radio label="Carte de fidélité" labelposition="left"
				id="radiobutton" name="client.carteFidelite"
				list="#{'true' : 'oui', 'false' : 'non'}" />

			<s:textfield type="hidden" name="codeCli">
				<s:param name="codeCli">${codeCli}</s:param>
			</s:textfield>
			<s:submit class="ButtPerso" value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>