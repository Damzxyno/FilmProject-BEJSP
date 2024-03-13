<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="content-header">
	<div class="header-menu">
		<img class="home-icon" src="./img/movie-icon.png" /> <span
			class="company-name">Damzxyno's Movie Archive</span>
	</div>
	<div class="header-search">
		<form action="${'FilmFilter'}" method="GET">
			<input class="header-search-input noborder" type="search"
				name="search" value="${param.search}"
				placeholder="Type movie name e.g, Legend of the seeker" />
			<button class="search-button noborder" type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</form>

	</div>
	<nav class="nav-menus">
		<a href="FilmCreate"> <i class="fa-solid fa-plus"></i> <span>Create
				a new film</span>
		</a> <a href="FilmFilter"> <i class="fa-solid fa-filter"></i> <span>Filter
				films</span>
		</a>
	</nav>
</header>