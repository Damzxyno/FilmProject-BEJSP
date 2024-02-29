package service;


import java.util.Optional;
import java.util.logging.Logger;

import dao.FilmDAO;
import dao.FilmDAOImpl;
import dto.PaginatedFilmsDTO;
import model.Film;

public class FilmServiceImpl implements FilmService{
	private final FilmDAO filmDAO;
	private final Logger logger = Logger.getLogger(FilmServiceImpl.class.getName());
	
	public FilmServiceImpl() {
		filmDAO = new FilmDAOImpl();
	}

	@Override
	public PaginatedFilmsDTO getAllFilms(int pageNo, int pageSize) {
		pageNo = pageNo > 0 ? pageNo : 1;
		pageSize = pageSize > 0 ? pageSize : 10;
		return filmDAO.getAll(pageNo, pageSize);
	}

	@Override
	public Optional<Film> getFilmByID(int id) {
		return filmDAO.get(id);
	}

	@Override
	public Film createNewFilm(String title, String director, int year, String review, String stars) {
		var film = Film.builder()
				.title(title)
				.director(director)
				.review(review)
				.stars(stars)
				.year(year)
				.build();
		filmDAO.insert(film);
		return film;
	}

	@Override
	public Optional<Film> updateFilm(int id, String title, String director, int year, String review, String stars) {
		var film = filmDAO.get(id);
		if (film.isPresent()) {
			film.get().setTitle(title);
			film.get().setDirector(director);
			film.get().setYear(year);
			film.get().setReview(review);
			film.get().setStars(stars);
			filmDAO.update(film.get());
			return film;
		}
		return Optional.empty();
		
	}

	@Override
	public String deleteFilmByID(int id) {
		return filmDAO.delete(id);
		
	}

	@Override
	public PaginatedFilmsDTO filterOutFilms(String searchStr, String director, int startYear, int endYear, String stars, int pageNumber, int pageSize) {
		pageNumber = pageNumber > 0 ? pageNumber : 1;
		pageSize = pageSize > 0 ? pageSize : 10;
		var res = filmDAO.getAll(searchStr, director, startYear, endYear, stars, pageNumber, pageSize);
		return res;
	}

}
