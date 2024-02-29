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

@WebServlet("/Films")
public class FilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final FilmService filmService;   
    
    public FilmController() {
        filmService = new FilmServiceImpl(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var pageNumber = Parser.tryGetHttpRequestIntParamOrDefault(request, "page-number");
		var pageSize = Parser.tryGetHttpRequestIntParamOrDefault(request, "page-size");
		var films = filmService.getAllFilms(pageNumber, pageSize);
		var view = request.getRequestDispatcher("films.jsp");
		request.setAttribute("films", films);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
