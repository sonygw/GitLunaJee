<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<table border="0" cellpadding="2" cellspacing="2" width="100%"
		height="100%">
		<tr>
			<td class="monbody" height="95%" width="100%"><tiles:insertAttribute
					name="body"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td class="monfooter" height="5%" colspan="2"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>
</html>