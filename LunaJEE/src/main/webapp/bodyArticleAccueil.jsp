<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

	<h1>Liste des Articles :</h1>

	<s:if test="getModels()!=null">
		<table>
			<tr>
				<td width="20%">Id</td>
				<td width="30%">Cat</td>
				<td width="30%">Description</td>
				<td>Voir Article</td>
				<td>Supprimer</td>
				<td>Modifier</td>
			</tr>

			<s:iterator value="getModels()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="20%"><s:property value="idArticle" /></td>
					<td width="30%"><s:property value="categorie" /></td>
					<td width="30%"><s:property value="description" /></td>
					<td><s:a action="voirArt">
							<img alt="VIEW" src="images/loupe.ico" width="30px">
							<s:param name="codeArt">
								<s:property value="idArticle" />
							</s:param>
						</s:a></td>
					<td><s:a action="deleteArt">
							<img alt="DEL" src="images/delete.png" width="30px">
							<s:param name="codeArt">
								<s:property value="idArticle" />
							</s:param>
						</s:a></td>
					<td><s:a action="updateArt1">
							<img alt="UPD" src="images/update.png" width="30px">
							<s:param name="codeArt">
								<s:property value="idArticle" />
							</s:param>
						</s:a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>