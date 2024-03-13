<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="pagination">
	<c:set var="isFilterPage" value="${param.isFilterPage}" />
	<c:choose>
		<c:when test="${isFilterPage == 'true'}">
			<c:url value="FilmFilter" var="visitURL">
				<c:param name="search" value="${param.search}" />
				<c:param name="director" value="${param.director}" />
				<c:param name="start-year" value="${param['start-year']}" />
				<c:param name="end-year" value="${param['end-year']}" />
				<c:param name="stars" value="${param.stars}" />
			</c:url>
		</c:when>
		<c:otherwise>
			<c:set var="visitURL" value="Films" />
		</c:otherwise>
	</c:choose>


	<c:if test="${films.hasPrevious()}">
		<c:url value="${visitURL}" var="prevUrl">
			<c:param name="page-number" value="${films.getPageNumber() - 1}" />
			<c:param name="page-size" value="${films.getPageSize()}" />
		</c:url>
		<div class="pagination-anchor">
			<a href="${prevUrl}">Previous</a>
		</div>

	</c:if>

	<c:forEach begin="1" end="${films.getTotalFilmsPages()}" var="page">
		<c:url value="${visitURL}" var="pageUrl">
			<c:param name="page-number" value="${page}" />
			<c:param name="page-size" value="${films.getPageSize()}" />
		</c:url>
		<c:choose>
			<c:when test="${page eq films.getPageNumber()}">
				<div class="pagination-anchor current-page">
					<span>${page}</span>
				</div>
			</c:when>
			<c:otherwise>
				<div class="pagination-anchor">
					<a href="${pageUrl}">${page}</a>
				</div>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${films.hasNext()}">
		<c:url value="${visitURL}" var="nextUrl">
			<c:param name="page-number" value="${films.getPageNumber() + 1}" />
			<c:param name="page-size" value="${films.getPageSize()}" />
		</c:url>
		<div class="pagination-anchor">
			<a href="${nextUrl}">Next</a>
		</div>
	</c:if>
</div>
