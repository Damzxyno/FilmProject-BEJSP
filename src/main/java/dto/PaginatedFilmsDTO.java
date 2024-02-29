package dto;

import java.util.List;
import model.Film;

/**
 * This class help to transmit a pagination metadata along with the films content.
 * @author damzxyno
 *
 */

public class PaginatedFilmsDTO {
    private int pageNumber;
    private int pageSize;
    private int currentFilmCount;
    private int totalFilmsCount;
    private int totalFilmsPages;
    private boolean hasNext;
    private boolean hasPrevious;
    private List<Film> films;

    public PaginatedFilmsDTO(int pageNumber, int pageSize, int totalFilmsCount, List<Film> films) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalFilmsCount = totalFilmsCount;
        this.films = films;
        this.currentFilmCount = films.size();
        this.totalFilmsPages = (int) Math.ceil((double) totalFilmsCount / pageSize);
        this.hasNext = pageNumber < totalFilmsPages;
        this.hasPrevious = pageNumber > 1;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentFilmCount() {
        return currentFilmCount;
    }

    public int getTotalFilmsCount() {
        return totalFilmsCount;
    }

    public int getTotalFilmsPages() {
        return totalFilmsPages;
    }

    public boolean hasNext() {
        return hasNext;
    }

    public boolean hasPrevious() {
        return hasPrevious;
    }

    public List<Film> getFilms() {
        return films;
    }
    
    @Override
    public String toString() {
        return "FilmContainer{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", currentFilmCount=" + currentFilmCount +
                ", totalFilmsCount=" + totalFilmsCount +
                ", totalFilmsPages=" + totalFilmsPages +
                ", hasNext=" + hasNext +
                ", hasPrevious=" + hasPrevious +
                ", films=" + films +
                '}';
    }
}
