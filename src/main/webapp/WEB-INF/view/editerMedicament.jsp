<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Modifier un Medicament</title>
</head>
<body>
<form action="updateMedicament" method="post">
<pre>
id : <input type="text" name="idMedicament" value="${medicament.idMedicament}">
nom :<input type="text" name="nomMedicament" value="${medicament.nomMedicament}">
prix :<input type="text" name="prixMedicament" value="${medicament.prixMedicament}">
Date creation : 
 <fmt:formatDate pattern="yyyy-MM-dd" value="${medicament.dateCreation}"var="formatDate" />
 <input type="date" name="date" value="${formatDate}"></input>
 Date Expiration : 
 <fmt:formatDate pattern="yyyy-MM-dd" value="${medicament.dateexpiration}"var="formatDate" />
 <input type="date" name="date" value="${formatDate}"></input>
<input type="submit" value="Modifier">
</pre>
</form>
<br/>
<br/>
<a href="ListeMedicament">Liste Medicament</a>
</body>
</html>