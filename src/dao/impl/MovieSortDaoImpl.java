package dao.impl;

import dao.MovieSortDao;
import models.Movie;

import java.util.Comparator;
import java.util.LinkedList;

public class MovieSortDaoImpl implements MovieSortDao {


    @Override
    public LinkedList<Movie> sortMovieByName(LinkedList<Movie> ascOrDesc) {
ascOrDesc.sort(new Comparator<Movie>() {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getName().compareTo(o2.getName());
    }
});
        return ascOrDesc;
    }

//    @Override
//    public void sortMovieByName(String ascOrDesc) {
//        ascOrDesc.sor
//    }

    @Override
    public LinkedList<Movie> sortByYear(LinkedList<Movie> ascOrDesc) {
        ascOrDesc.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getYear().compareTo(o2.getYear());
            }
        });
        return ascOrDesc;
    }

    @Override
    public LinkedList<Movie> sortByProducer(LinkedList<Movie> nameOrLastName) {
        nameOrLastName.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getProducer().getLastName().compareTo(o2.getProducer().getLastName());
            }
        });
        return nameOrLastName;
    }
}
