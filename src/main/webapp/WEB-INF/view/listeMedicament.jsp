<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Medicaments</title>
</head>
<body>
 <h1 >
 Liste des Medicaments
 </h1> 
 <table >
 <tr>
 <th>ID</th><th>Nom Medicaments</th><th>Prix</th><th>Date 
Creation</th><th>Date  Expiration</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${medicaments}" var="m">
 <tr>
 <td>${m.idMedicament }</td>
 <td>${m.nomMedicament }</td>
 <td>${m.prixMedicament }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"value="${m.dateCreation}" /></td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"value="${m.dateexpiration}" /></td>

 <td><a onclick= "return confirm('Etes-vous sur ?')" href="supprimerMedicament?id=${p.idMedicament }">Supprimer</a></td>
 <td><a href="modifierMedicament?id=${p.idMedicament }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
</body>
</html>