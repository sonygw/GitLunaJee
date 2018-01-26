<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Article</title>
</head>
<body>

	<s:form action="submitAjout">

Nom : 
		<s:property value="article.nom" />
		<br>
		<br>	
		Code : 
		<s:property value="article.code" />
		<br>
		<br>	
		Description : 
		<s:property value="article.description" />
		<br>
		<br>
		Catégorie : 
		<s:property value="article.categorie" />
		<br>
		<br>
		Prix : 
		<s:property value="article.prixHT" />
&euro;	

<br>
		<%-- <s:property value="codeArt" /> --%>
		<br>

		<s:if test="article.quantite > 0">
			<s:textfield class="textFieldPerso" placeholder="Quantité" name="qte" value="" style="position: absolute; left:85% ; top: 65%;"
				required="true" labelposition="left">
			</s:textfield>
			<s:submit class="ButtPerso" value="Ajouter au panier !"	/>
			
		</s:if>
		<s:else>
			<s:submit disabled="1" class="ButtPerso"
				value="Article indisponible !" Style="align:right">
				<s:param name="codeArt">
					<s:property value="idArticle" />
				</s:param>
			</s:submit>


		</s:else>

	</s:form>


</body>
</html>