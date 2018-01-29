<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prévisualisation</title>
<style type="text/css">
table {

border: 1px solid black;
}

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


	<s:if test="getPreview() == 'client'">
		<table>
			<tr>
				<td width="20%">Nom</td>
				<td width="20%">Prenom</td>
				<td width="20%">Email</td>
				<td width="30%">Telephone</td>
				<td width="40%">Adresse</td>
			</tr>

			<s:iterator value="getClients()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="20%"><s:property value="nom" /></td>
					<td width="20%"><s:property value="prenom" /></td>
					<td width="20%"><s:property value="email" /></td>
					<td width="30%"><s:property value="numeroTelephone" /></td>
					<td width="40%"><s:property value="adresse" /></td>

				</tr>
			</s:iterator>
		</table>

	</s:if>


	<s:if test="getPreview() == 'commande'">

		<h1>Liste des Commandes :</h1>
		<table>
			<tr>

				<td width="30%">Nom</td>
				<td width="30%">Prenom</td>
				<td width="30%">Code Commande</td>
				<td width="30%">Date Commande</td>
				<td width="30%">Prix Commande</td>
			</tr>

			<s:iterator value="getCommandes()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="20%"><s:property value="nomCli" /></td>
					<td width="20%"><s:property value="prenomCli" /></td>
					<td width="20%"><s:property value="ref" /></td>
					<td width="20%"><s:property value="date" /></td>
					<td width="20%"><s:property value="prixHT" /> &euro;</td>


				</tr>
			</s:iterator>
		</table>
	</s:if>


	<s:if test="getPreview() == 'article'">

		<h1>Liste des Articles :</h1>


		<table>
			<tr>
				<td width="30%">Cat</td>
				<td width="30%">Description</td>
				<td width="30%">Prix</td>
				<td width="30%">Quantite</td>
			</tr>

			<s:iterator value="getArticles()" status="modelsStatus">
				<tr
					class="<s:if test="#modelsStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td width="30%"><s:property value="categorie" /></td>
					<td width="30%"><s:property value="description" /></td>
					<td width="30%"><s:property value="prixHT" /></td>
					<td width="30%"><s:property value="quantite" /></td>

				</tr>
			</s:iterator>
		</table>




	</s:if>

	<input class="ButtPerso" type="button" onClick="print();" value="Imprimer cette page">


</body>
</html>