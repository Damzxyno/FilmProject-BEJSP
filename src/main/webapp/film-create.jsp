<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="./fragment/head.jsp">
	<jsp:param name="title" value="Create Film - Damzxyno's" />
</jsp:include>
<body>
	<jsp:include page="./fragment/header.jsp" />
	<div class="general-content">
		<main>
		   <jsp:include page="./fragment/content-background.jsp" />
		    <div class="main-content" >
		    	<c:if test="${not empty message}">
				    <div id="disclaimer">${message}</div>
				</c:if>
		    	<form action="FilmCreate" method="post">
			        <input type="hidden" name="id" value="${film.id}">
			        <label for="title">Title:</label>
			        <input type="text" name="title" value="${film.title}" required><br>
			        <label for="year">Year:</label>
			        <input type="number" name="year" value="${film.year}" required><br>
			        <label for="director">Director:</label>
			        <input type="text" name="director" value="${film.director}" required><br>
			        <label for="stars">Stars:</label>
			        <input type="text" name="stars" value="${film.stars}" required><br>
			        <label for="review">Review:</label>
			        <textarea name="review" rows="4" cols="50" required>${film.review}</textarea><br>
			        <input type="submit" value="Create Film">
    			</form>
			</div>
		</main>
	</div>
</body>
</html>