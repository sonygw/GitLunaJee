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

	<s:form style="background-color:white" action="">

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
<s:submit class="submitAjout" value="Ajouter au panier !" Style="align:right"></s:submit>
	</s:form>


</body>
</html>