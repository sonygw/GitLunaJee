<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'un Article</title>
</head>
<body>

<fieldset>
		<legend>Ajout d'un article</legend>
		<s:form method="post" action="createArt">
			<div>
				<s:textfield label="Catégorie" name="categorie"
				required="true"	labelposition="left" />
				<s:textfield label="Description" name="description"
					required="true" labelposition="left" />

				<s:textfield label="Prix HT" name="prixHT" required="true"
					labelposition="left" />
					
				<s:textfield label="Quantité" name="quantite"
					required="true" labelposition="left" />
					
			</div>		
			<s:submit value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>