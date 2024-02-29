<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="pagination" style="background-color: green;"> 
			    <c:url value="FilmFilter" var="paginationUrl">
			        <c:param name="search" value="${param.search}" />
			        <c:param name="director" value="${param.director}" />
			        <c:param name="start-year" value="${param['start-year']}" />
			        <c:param name="end-year" value="${param['end-year']}" />
			        <c:param name="stars" value="${param.stars}" />
			    </c:url>
			
			    <c:if test="${films.hasPrevious()}">
			        <c:url value="${paginationUrl}" var="prevUrl">
			            <c:param name="page-number" value="${films.getPageNumber() - 1}" />
			            <c:param name="page-size" value="${films.getPageSize()}" />
			        </c:url>
			        <a href="${prevUrl}">Previous</a>
			    </c:if>
			
			    <c:forEach begin="1" end="${films.getTotalFilmsPages()}" var="page">
			        <c:url value="${paginationUrl}" var="pageUrl">
			            <c:param name="page-number" value="${page}" />
			            <c:param name="page-size" value="${films.getPageSize()}" />
			        </c:url>
			        <c:choose>
			            <c:when test="${page eq films.getPageNumber()}">
			                <span class="current-page">${page}</span>
			            </c:when>
			            <c:otherwise>
			                <a href="${pageUrl}">${page}</a>
			            </c:otherwise>
			        </c:choose>
			    </c:forEach>
			
			    <c:if test="${films.hasNext()}">
			        <c:url value="${paginationUrl}" var="nextUrl">
			            <c:param name="page-number" value="${films.getPageNumber() + 1}" />
			            <c:param name="page-size" value="${films.getPageSize()}" />
			        </c:url>
			        <a href="${nextUrl}">Next</a>
			    </c:if>
			</div>
