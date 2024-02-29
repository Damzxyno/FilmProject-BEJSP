package service;

import java.util.Optional;
import dto.PaginatedFilmsDTO;
import model.Film;

public interface FilmService {
	PaginatedFilmsDTO getAllFilms(int pageNo, int pageSize);
	Optional<Film> getFilmByID(int id);
	Film createNewFilm(String title, String director, int year, String review, String stars);
	Optional<Film> updateFilm(int id, String title, String director, int year, String review, String stars);
	String deleteFilmByID(int id);
	PaginatedFilmsDTO filterOutFilms(String searchStr, String director, int startYear, int endYear, String stars, int pageNumber, int pageSize);
}
