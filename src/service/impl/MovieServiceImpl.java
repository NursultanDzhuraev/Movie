package service.impl;

import dao.impl.MovieDaoImpl;
import enam.Genre;
import models.Movie;
import service.MovieService;

import java.time.LocalDate;
import java.util.List;

public class MovieServiceImpl implements MovieService {
private final MovieDaoImpl movieDao;

    public MovieServiceImpl(MovieDaoImpl movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        return movieDao.findMovieByFullNameOrPartName(name);
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        return movieDao.findMovieByActorName(actorName);
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        return movieDao.findMovieByYear(year);
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        return movieDao.findMovieByProducer(producerFullName);
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        return movieDao.findMovieByGenre(genre);
    }

    @Override
    public Movie findMovieByRole(String role) {
        return movieDao.findMovieByRole(role);
    }
}
