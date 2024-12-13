package service;

import models.Movie;

import java.util.LinkedList;

public interface MovieSortService {
    //    void sortMovieByName(String ascOrDesc);
    LinkedList<Movie> sortMovieByName(LinkedList<Movie> ascOrDesc);

    LinkedList<Movie> sortByYear(LinkedList<Movie> ascOrDesc);

    LinkedList<Movie> sortByProducer(LinkedList<Movie> nameOrLastName);
}
