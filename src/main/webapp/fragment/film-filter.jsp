<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="filter-section">
	                <form action="FilmFilter" method="GET">
	                    <label for="search">Search:</label>
	                    <input type="text" name="search" id="search" value="${param.search}">
	                    
	                    <label for="director">Director:</label>
	                    <input type="text" name="director" id="director" value="${param.director}">
	                    
	                    <label for="startYear">Start Year:</label>
	                    <input type="text" name="start-year" id="start-year" value="${param['start-year']}">
	                    
	                    <label for="endYear">End Year:</label>
	                    <input type="text" name="end-year" id="end-year" value="${param['end-year']}">
	                    
	                    <label for="stars">Stars:</label>
	                    <input type="text" name="stars" id="stars" value="${param.stars}">
	                    
	                    <button type="submit">Apply Filters</button>
	                </form>
	            </div>