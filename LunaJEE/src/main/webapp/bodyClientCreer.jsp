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
				<s:textfield label="Nom" name="nom"
					required="true" labelposition="left" />
				<s:textfield label="Prenom" name="prenom"
					required="true" labelposition="left" />

				<s:textfield label="Email" name="email" required="true"
					labelposition="left" />
					
				<s:textfield label="remarques" name="remarques"
					required="true" labelposition="left" />
					
					<s:textfield label="Telephone" name="numeroTelephone"
								required="true" labelposition="left" />

				<s:textfield label="Adresse" name="adresse" 
					required="true" labelposition="left" />
			</div>
			<s:radio label="Carte de fidélité" labelposition="left"
				id="radiobutton" name="carteFidelite"
				list="#{'true' : 'oui', 'false' : 'non'}" />
		
			<s:submit value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>