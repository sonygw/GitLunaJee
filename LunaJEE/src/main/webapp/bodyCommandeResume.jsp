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

	<s:form> R�f�rence Commande : <s:property value="commande.ref" />
	</s:form>
	<s:form> Nom Client : <s:property value="commande.client.nom" />
	</s:form>
	<s:form> Pr�nom Client : <s:property
			value="commande.client.prenom" />
	</s:form>
	<s:form> Prix : <s:property value="commande.prixHT" />&euro;</s:form>


	<table id="myTable">


		<tr style="background-color: silver;">
			<td width="20%">R�f�rence</td>
			<td width="30%">Description</td>
			<td width="30%">Quantit� achet�e</td>
		</tr>

<s:iterator value="getArtCom()" status = "modelsStatus">
		<tr style="border-width: 1px; border-style: solid">
			<td><s:property value="article.code" /></td>
			<td><s:property value="article.description" /></td>
			<td><s:property value="quantite" /></td>

		</tr>
</s:iterator>
	</table>




</body>
</html>