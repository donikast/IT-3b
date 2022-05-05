<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="repositories.Repository" %>
<%@ page import="models.User" %>

<!DOCTYPE html>
<html lang="bg">
<jsp:include page="shared/head.jsp"></jsp:include>

<body>
<% Repository collection = Repository.getInstance(); %>
<jsp:include page="shared/header.jsp"></jsp:include>

<div class="content">

<h1>Съжаляваме, нещо се обърка!</h1>

</div>
<jsp:include page="shared/footer.jsp"></jsp:include>

</body>
</html>