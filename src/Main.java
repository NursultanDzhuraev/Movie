import dao.impl.MovieDaoImpl;
import dao.impl.MovieSortDaoImpl;
import dateBase.DateBase;
import enam.Genre;
import models.Actor;
import models.Movie;
import models.Producer;
import service.MovieSortService;
import service.impl.MovieServiceImpl;
import service.impl.MovieSortServiceImpl;

import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanForStr = new Scanner(System.in);
    static Scanner scanForNumber = new Scanner(System.in);
    public static void main(String[] args) {
        MovieDaoImpl movieDao = new MovieDaoImpl();
        MovieServiceImpl movieService = new MovieServiceImpl(movieDao);

        MovieSortDaoImpl movieSortDao = new MovieSortDaoImpl();
        MovieSortServiceImpl movieSortService = new MovieSortServiceImpl(movieSortDao);

        List<Actor> actor1 = new LinkedList<>(List.of(
                new Actor("Бауржан Каптагаев", "q"),
                new Actor("Айтурган Темирова", "w"),
                new Actor("Ерлан Кулмурзин", "e")));
        List<Actor> actor2 = new LinkedList<>(List.of(
                new Actor("Элина Абай кызы", "r"),
                new Actor("Назира Мамбетова", "t"),
                new Actor("Мирлан Абдулаев", "y")));
        List<Actor> actor3 = new LinkedList<>(List.of(
                new Actor("Рауан Ахмедов", "u"),
                new Actor("Дамир Амангельдин,", "i"),
                new Actor("Бегайым Асанакунова", "o")));
        List<Actor> actor4 = new LinkedList<>(List.of(
                new Actor("Атай Омурбеков", "p"),
                new Actor("Адыл Болорбек уулу", "a"),
                new Actor("Жылдызбек Касейинов", "s")));
        DateBase.movies.add(new Movie("Salam, Europe", LocalDate.of(2000, 1, 1),
                Genre.COMEDY, new Producer("Руслан ", " Акун"), actor1));
        DateBase.movies.add(new Movie(" Queen of the Mountains", LocalDate.of(2014, 1, 1),
                Genre.HISTORICAL, new Producer("Садык", "Шер-Нияз"), actor2));
        DateBase.movies.add(new Movie("Приговор", LocalDate.of(2024, 1, 1),
                Genre.THRILLER, new Producer("Диас", "Бертис"), actor3));
        DateBase.movies.add(new Movie("Разбой", LocalDate.of(2023, 1, 1),
                Genre.ACTION, new Producer("Максат", "Жумаев"), actor4));

        while (true) {
            System.out.println("""
                    0 Exit
                    1 getAllMovies
                    2 findMovieByFullNameOrPartName
                    3 findMovieByActorName
                    4 findMovieByYear
                    5 findMovieByProducer
                    6 findMovieByGenre
                    7 findMovieByRole
                    8 sortMovieByName
                    9 sortByYear
                    10 sortByProducer
                    """);
            switch (checkValidCommand()){
                case 0->{
                    return;
                }
                case 1->{
                    System.out.println(movieService.getAllMovies());
                }
                case 2->{
                    System.out.print("Enter Movie name: ");
                    System.out.println(movieService.findMovieByFullNameOrPartName(scanForStr.nextLine()));
                }
                case 3->{
                    System.out.print("Enter actor name: ");
                    System.out.println(movieService.findMovieByActorName(scanForStr.nextLine()));
                }
                case 4->{
                    System.out.print("Enter movie year: ");
                    System.out.println(movieService.findMovieByYear(LocalDate.of((int) scanForNumber.nextLong(), 1, 1)));
                }
                case 5->{
                    System.out.print("Enter movie producer: ");
                    System.out.println(movieService.findMovieByProducer(scanForStr.nextLine()));
                }
                case 6->{
                    System.out.print("Enter movie genre(ACTION,THRILLER,HISTORICAL,COMEDY):");
                    System.out.println(movieService.findMovieByGenre(Genre.valueOf(scanForStr.nextLine().toUpperCase())));
                }
                case 7->{
                    System.out.println("Enter movie role");
                    System.out.println(movieService.findMovieByRole(scanForStr.nextLine()));
                }
                case 8->{
                    System.out.println(movieSortService.sortMovieByName(DateBase.movies));
                }
                case 9->{
                    System.out.println(movieSortService.sortByYear(DateBase.movies));
                }
                case 10->{
                    System.out.println(movieSortService.sortByProducer(DateBase.movies));
                }
            }

        }
    }

    public static int checkValidCommand() {
        int command = 0;
        boolean invalidCommand;
        System.out.print("write command: ");
        do {
            try {
                command = new Scanner(System.in).nextInt();
                invalidCommand = false;
            } catch (InputMismatchException e) {
                invalidCommand = true;
                System.out.print("invalid command. Enter valid command: ");
            }
        } while (invalidCommand);
        return command;
    }
}