package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FilmService;
import service.FilmServiceImpl;
import util.Parser;

/**
 * Servlet implementation class FilmFilterController
 */
@WebServlet("/FilmFilter")
public class FilmFilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FilmService filmService; 
   
    public FilmFilterController() {
    	filmService = new FilmServiceImpl(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var pageNumber = Parser.tryGetHttpRequestIntParamOrDefault(request, "page-number");
		var pageSize = Parser.tryGetHttpRequestIntParamOrDefault(request, "page-size");
		var director = Parser.tryGetHttpRequestStringParamOrDefault(request, "director");
		var startYear = Parser.tryGetHttpRequestIntParamOrDefault(request, "start-year");
		var endYear = Parser.tryGetHttpRequestIntParamOrDefault(request, "end-year");
		var stars =  Parser.tryGetHttpRequestStringParamOrDefault(request, "star");
		var searchStr = Parser.tryGetHttpRequestStringParamOrDefault(request, "search");
		var films = filmService.filterOutFilms(searchStr, director, startYear, endYear, stars, pageNumber, pageSize);
		var view = request.getRequestDispatcher("films-filter.jsp");
		request.setAttribute("films", films);
		var initialController = "FilmFilter" + getQueryParams(request);
		request.setAttribute("initialController", initialController);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String getQueryParams(HttpServletRequest request) {
		var stringBuilder = new StringBuilder();
		var parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            if (paramValue != null && !paramValue.isBlank()) {
            	stringBuilder.append(String.format("%s=%s&", paramName, paramValue));
            }   
        }
        if (stringBuilder.length() > 0) {
        	return "?" + stringBuilder.toString().substring(0, stringBuilder.length() - 1);
        }
        return "";
	}
}
