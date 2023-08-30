<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
    <div class="container">
        <%-- Check if the user is null --%>
        <c:if test="${user == null}">
            <h1>Add User</h1>
            <form action="/addUser" method="post">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom" name="nom" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" required>
                </div>
                <div class="form-group">
                    <label for="age">Âge</label>
                    <input type="number" class="form-control" id="age" name="age" required>
                </div>
                <button type="submit" class="btn btn-primary">Add User</button>
            </form>
        </c:if>

        <c:if test="${user != null}">
            <form action="/editUser" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <div class="form-group">
                    <label for="nom">Nom</label>
                    <input type="text" class="form-control" id="nom1" name="nom" value="${user.nom}" required>
                </div>
                <div class="form-group">
                    <label for="prenom">Prénom</label>
                    <input type="text" class="form-control" id="prenom1" name="prenom" value="${user.prenom}" required>
                </div>
                <div class="form-group">
                    <label for="age">Âge</label>
                    <input type="number" class="form-control" id="age1" name="age" value="${user.age}" required>
                </div>
                <button type="submit" class="btn btn-primary">Save Changes</button>
            </form>
        </c:if>



        <h1>User Management</h1>
        <a class="btn btn-primary" href="/addUser">Add User</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Âge</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${personnes}">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.nom}" /></td>
                        <td><c:out value="${user.prenom}" /></td>
                        <td><c:out value="${user.age}" /></td>
                        <td>
                            <a class="btn btn-warning" href="/editPersonne?id=${user.id}">
                                <i class="fas fa-edit"></i> Edit
                            </a>
                            <a class="btn btn-danger" href="/deletePersonne?id=${user.id}">
                                <i class="fas fa-trash"></i> Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>