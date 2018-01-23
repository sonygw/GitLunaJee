<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification d'un article</title>
</head>
<body>
	<fieldset>
		<legend>Modification d'un Article</legend>
		<%-- 		<s:property value="article.categorie" /> --%>

		<%-- <s:property value="article.description" /> --%>

		<s:form method="post" action="updateArt2">
			<div>
				<s:textfield label="Catégorie" name="article.categorie"
					required="true" labelposition="left" >
				</s:textfield>

				<s:textfield label="Description" name="article.description"
					 required="true"
					labelposition="left">
				</s:textfield>

			

				<s:textfield label="Prix HT" name="article.prixHT"
					 required="true" labelposition="left">
				</s:textfield>

				<s:textfield label="Quantité" name="article.quantite"
					required="true" labelposition="left">
				</s:textfield>

			</div>

			<s:textfield type="hidden" name="codeArt">
				<s:param name="codeArt">${codeArt}</s:param>
			</s:textfield>
			<s:submit value="Enregistrer" label="Enregistrer" />
		</s:form>
	</fieldset>
</body>
</html>