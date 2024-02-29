package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import service.FilmService;
import service.FilmServiceImpl;
import util.Parser;


@WebServlet("/FilmCreate")
public class FilmCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final FilmService filmService;   
    
    public FilmCreateController() {
        filmService = new FilmServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var view = request.getRequestDispatcher("film-create.jsp");
		request.setAttribute("film", new Film());
		view.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    var title = request.getParameter("title");  
	    var director = request.getParameter("director");
	    var stars = request.getParameter("stars");
	    var review = request.getParameter("review");
	    var year = Parser.tryGetHttpRequestIntParamOrDefault(request, "year");  
		filmService.createNewFilm(title, director, year, review, stars);
		var view = request.getRequestDispatcher("film-create.jsp");
		request.setAttribute("film", new Film());
		request.setAttribute("message", String.format("Film: '%s' created Successfully!", title));
		view.forward(request, response);
	}
}
