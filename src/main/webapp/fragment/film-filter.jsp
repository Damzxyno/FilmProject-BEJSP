<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="filter-section">
	<form class="filter-section-form" action="FilmFilter" method="GET">
		<div class="filter-search-box>">
			<label for="search">Search:</label> 
			<input class="filter-search-input" type="text" name="search" id="search" value="${param.search}">
		</div>
		<div class="filter-section-form-box">
			<div class="filter-section-form-box-item">
				<label for="director">Director:</label> 
			<input class="filter-section-input" type="text" name="director" id="director" value="${param.director}"> 
			</div>
			<div class="filter-section-form-box-item">
			<label for="startYear">Start Year:</label> 
			<input class="filter-section-input" type="text"	name="start-year" id="start-year" value="${param['start-year']}">
			</div>
		</div>
		<div class="filter-section-form-box">
		<div class="filter-section-form-box-item">
			<label for="endYear">End Year:</label> 
			<input class="filter-section-input" type="text" name="end-year" id="end-year" value="${param['end-year']}">
			</div>
			<div class="filter-section-form-box-item">
			<label for="stars">All  Stars:</label>
			 <input class="filter-section-input" type="text" name="stars" id="stars" value="${param.stars}">
			 </div>
		</div>


		<button class="filter-section-button" type="submit">Apply Filters</button>
	</form>
</div>