<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errors {
	background-color: #FFCCCC;
	border: 1px solid #CC0000;
	width: 400px;
	margin-bottom: 8px;
}

.errors li {
	list-style: none;
}

.odd {
	background-color: silver;
}

.even {
	background-color: white;
}
</style>
</head>
<body>

	<h1>Liste des Articles dans le panier :</h1>

	<s:if test="getModels().size != 0">
		<table>
			<tr>
				<td width="20%">Id</td>
				<td width="30%">Cat</td>
				<td width="30%">Description</td>
				<td width="30%">Qte</td>
				<td width="30%">Prix</td>
				<td>Supprimer</td>
			</tr>

			<s:iterator value="getModels()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="20%"><s:property value="article.idArticle" /></td>
					<td width="30%"><s:property value="article.categorie" /></td>
					<td width="30%"><s:property value="article.description" /></td>
					<td width="30%"><s:property value="quantite" /></td>
					<td width="30%"><s:property value="prixHT" /></td>
					<td><s:a action="deletePan">
							<img alt="DEL" src="images/delete.png" width="30px">
							<s:param name="codePan"><s:property value="idPanier" /></s:param>
						</s:a></td>
					
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>
	
	Panier vide !
	
	</s:else>


</body>
</html>