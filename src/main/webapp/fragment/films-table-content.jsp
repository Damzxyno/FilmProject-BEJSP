<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String message = request.getParameter("message");
    if (message != null) {
%>
    <div class="disclaimer">${message}</div>
<%
    }
%>
<table class="films-table">
		            <thead>
		                <tr>
		                    <th>Title</th>
		                    <th>Description</th>
		                    <th>Stars</th>
		                    <th>Director</th>
		                    <th>Year</th>
		                    <th colspan="2">Action</th>
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach items="${films.getFilms()}" var="film">
		                    <tr>
		                        <td>${film.title}</td>
		                        <td>${film.review}</td>
		                        <td>${film.stars}</td>
		                        <td>${film.director}</td>
		                        <td>${film.year}</td>
		                       <td class="table-anchor">
								    <form id="deleteFilmForm${film.id}" action="FilmDelete" method="POST">
								        <input type="hidden" name="id" value="${film.id}" />
								        <input type="hidden" name="redirectPage" value="${pageContext.request.requestURI}" />
								
								        <button type="submit" onclick="deleteFilm('${film.title}', event)">
								            <i class="fa-solid fa-trash"></i>
								            <span>Delete</span>
								        </button>
								    </form>
								</td>
		                        <td class="table-anchor">
		                            <a href="FilmEdit?id=${film.id}">
			                            <button>
			                            	<i class="fa-solid fa-pen-to-square"></i>
			                                <span>Edit</span>
			                            </button>
		                            </a>
		                        </td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>    
