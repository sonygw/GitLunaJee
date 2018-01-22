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
	<fieldset>
		<legend>Modification</legend>
		<s:form method="post" action="updateCli2">
			<div>
				<s:textfield label="Nom" name="clientUpdate.nom"
					labelposition="left" />
				<s:textfield label="Prenom" name="clientUpdate.prenom"
					required="true" labelposition="left" />

				<s:textfield label="Email" name="clientUpdate.email" required="true"
					labelposition="left" />
					
				<s:textfield label="remarques" name="clientUpdate.remarques"
					required="true" labelposition="left" />
					
					<s:textfield label="Telephone" name="clientUpdate.numeroTelephone"
								required="true" labelposition="left" />

				<s:textfield label="Adresse" name="clientUpdate.adresse" value="clientUpdate.getAdresse()"
					required="true" labelposition="left" />
			</div>
			<s:radio label="Carte de fidélité" labelposition="left"
				id="radiobutton" name="clientUpdate.carteFidelite"
				list="#{'true' : 'oui', 'false' : 'non'}"
				value="clientUpdate.isCarteFidelite()" />

			<s:textfield type="hidden" name="codeCli">
				<s:param name="codeCli">${codeCli}</s:param>
			</s:textfield>
			<s:submit value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>