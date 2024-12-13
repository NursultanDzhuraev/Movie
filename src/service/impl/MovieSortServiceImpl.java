package service.impl;

import dao.impl.MovieSortDaoImpl;
import models.Movie;
import service.MovieSortService;

import java.util.LinkedList;

public class MovieSortServiceImpl implements MovieSortService {
    private final MovieSortDaoImpl movieSortServiceDao;

    public MovieSortServiceImpl(MovieSortDaoImpl movieSortServiceDao) {
        this.movieSortServiceDao = movieSortServiceDao;
    }


    @Override
    public LinkedList<Movie> sortMovieByName(LinkedList<Movie> ascOrDesc) {
        return movieSortServiceDao.sortMovieByName(ascOrDesc);
    }

//    @Override
//    public void sortMovieByName(String ascOrDesc) {
//
//    }

    @Override
    public LinkedList<Movie> sortByYear(LinkedList<Movie> ascOrDesc) {
        return movieSortServiceDao.sortByYear(ascOrDesc);
    }

    @Override
    public LinkedList<Movie> sortByProducer(LinkedList<Movie> nameOrLastName) {
        return movieSortServiceDao.sortByProducer(nameOrLastName);
    }
}
