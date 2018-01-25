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

	<s:form style="background-color:white" action="submitAjout">

		Code : 
		<s:property value="article.code" />
		<br>
		<br>	
		Description : 
		<s:property value="article.description" />
		<br>
		<br>
		Cat�gorie : 
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
			<s:textfield label="Quantit�" name="qte" required="true"
				labelposition="left">
			</s:textfield>
			<s:submit class="submitAjout" value="Ajouter au panier !"
				Style="align:right">
				<s:param name="codeArt">
					<s:property value="idArticle" />
				</s:param>
			</s:submit>
		</s:if>
		<s:else>
			<s:submit disabled="1" class="submitAjout"
				value="Article indisponible !" Style="align:right">
				<s:param name="codeArt">
					<s:property value="idArticle" />
				</s:param>
			</s:submit>


		</s:else>
	</s:form>


</body>
</html>