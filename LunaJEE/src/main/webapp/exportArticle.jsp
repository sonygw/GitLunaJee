<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<display:table id="exportArticle" name="session.Article.listArt" pagesize="10">
		<display:column property="idArticle" title="Id" sortable="true"
			media="html" group="1" />
		<display:column property="categorie" title="Categorie" sortable="true" />
		<display:column property="description" title="Description"
			sortable="true" />
		<display:setProperty name="export.pdf" value="true" />
	</display:table>




</body>
</html>