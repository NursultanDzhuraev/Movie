package dao.impl;

import dao.MovieDao;
import dateBase.DateBase;
import enam.Genre;
import models.Actor;
import models.Movie;


import java.time.LocalDate;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    @Override
    public List<Movie> getAllMovies() {
        return DateBase.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {

        boolean isTrue = false;
        for (Movie movie : DateBase.movies) {
            isTrue = true;
            if (movie.getName().startsWith(name)){
//            if (movie.getName().equalsIgnoreCase(name)) {
                isTrue = true;
                return movie;

            }
        }
        if (!isTrue) {
            System.out.println("There is no such movie.");
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : DateBase.movies) {
            if (movie.getActors() != null) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().startsWith(actorName)){
//                    if (actor.getActorFullName().equalsIgnoreCase(actorName)) {

                        return movie;
                    }
                }
            }
        }
        System.out.println("There is no such movie.");
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : DateBase.movies) {
            if (movie.getYear().equals(year)) {
                return movie;
            }
        }
        System.out.println("No films  this year");
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : DateBase.movies) {
            if (movie.getProducer() != null) {
               if (movie.getProducer().getLastName().equalsIgnoreCase(producerFullName) ||
                movie.getProducer().getFirstName().equalsIgnoreCase(producerFullName)){
                   return movie;
               }
            }
        }
        System.out.println("This Producer has no film.");
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : DateBase.movies) {
            if (movie.getGenre() != null) {
                if (movie.getGenre().equals(genre)) {
                    return movie;
                }
            }
        }
        System.out.println("no film of this genre");
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : DateBase.movies) {
           if (movie.getActors()!=null){
               for (Actor actor : movie.getActors()) {
                   if (actor.getRole().equalsIgnoreCase(role)){
                       return movie;
                   }
               }
           }
        }
        System.out.println("not found");
        return null;
    }
}
