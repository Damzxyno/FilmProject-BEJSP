<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="./fragment/head.jsp">
	<jsp:param name="title" value="Damzxyno's Films" />
</jsp:include>
<body>
	<jsp:include page="./fragment/header.jsp" />
	<div class="general-content">
		<main>
		    <figure class="content-figure">
		        <img class="content-figure-image" src="./img/cinema-background.jpeg" />
		    </figure>
		    <div class="main-content" >
		    	<jsp:include page="./fragment/film-filter.jsp" />
		        <jsp:include page="./fragment/films-table-content.jsp" />
		    </div>
		    <jsp:include page="./fragment/films-pagination.jsp" />
		</main>
		<footer class="general-footer">
		
		</footer>
	</div>  
</body>
</html>