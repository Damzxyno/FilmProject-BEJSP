<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="./fragment/head.jsp">
	<jsp:param name="title" value="Create Film - Damzxyno's" />
</jsp:include>
<body>
	<jsp:include page="./fragment/header.jsp" />
	<div class="general-content">
		<main> <jsp:include page="./fragment/content-background.jsp" />
		<div class="main-content">
			<c:if test="${not empty message}">
				<div id="disclaimer">${message}</div>
			</c:if>
			<form action="FilmCreate" method="post" class="film-form">
				<input type="hidden" name="id" value="${film.id}"> <label
					for="title" class="form-label">Title:</label> <input type="text"
					name="title" value="${film.title}" class="form-input" required><br>
				<label for="year" class="form-label">Year:</label> <input
					type="number" name="year" value="${film.year}" class="form-input"
					required><br> <label for="director" class="form-label">Director:</label>
				<input type="text" name="director" value="${film.director}"
					class="form-input" required><br> <label for="stars"
					class="form-label">Stars:</label> <input type="text" name="stars"
					value="${film.stars}" class="form-input" required><br>
				<label for="review" class="form-label">Review:</label>
				<textarea name="review" rows="4" cols="50" class="form-textarea"
					required>${film.review}</textarea>
				<br> <input type="submit" value="Create Film"
					class="form-submit">
			</form>
			<jsp:include page="./fragment/footer.jsp" />
		</div>
		</main>
	</div>
</body>
</html>