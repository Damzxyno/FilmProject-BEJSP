package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FilmService;
import service.FilmServiceImpl;
import util.Parser;

@WebServlet("/FilmEdit")
public class FilmEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(FilmEditController.class.getName());
	private final FilmService filmService;   
    public FilmEditController() {
        filmService = new FilmServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var filmID = Integer.parseInt(request.getParameter("id"));
		var film = filmService.getFilmByID(filmID);
		var view = request.getRequestDispatcher("film-edit.jsp");
		request.setAttribute("film", film.get());
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var filmID = Parser.tryGetHttpRequestIntParamOrDefault(request, "id");
	    var newTitle = request.getParameter("title");  
	    var newDirector = request.getParameter("director");
	    var newStars = request.getParameter("stars");
	    var newReview = request.getParameter("review");
	    var newYear = Parser.tryGetHttpRequestIntParamOrDefault(request, "year");  
		var film = filmService.updateFilm(filmID, newTitle, newDirector, newYear, newReview, newStars);
		var view = request.getRequestDispatcher("film-edit.jsp");
		request.setAttribute("film", film.get());
		request.setAttribute("message", String.format("Film: '%s' updated successfully!", newTitle));
		view.forward(request, response);
	}
}
