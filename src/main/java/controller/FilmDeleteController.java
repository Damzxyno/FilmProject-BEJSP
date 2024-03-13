package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FilmService;
import service.FilmServiceImpl;

@WebServlet("/FilmDelete")
public class FilmDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = Logger.getLogger(FilmEditController.class.getName());
    private final FilmService filmService;   
    public FilmDeleteController() {
        filmService = new FilmServiceImpl();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var filmID = Integer.parseInt(request.getParameter("id"));
		var filmTitle = filmService.deleteFilmByID(filmID);
		request.setAttribute("message", String.format("Film: '%s' deleted successfully!", filmTitle));
		String redirectPage = request.getParameter("redirectPage");
        response.sendRedirect(redirectPage);
	}

}