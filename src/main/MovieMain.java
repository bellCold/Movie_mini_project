package main;

import view.GradeView;
import view.MovieView;
import view.TheaterView;
import view.UserView;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView(scanner);
        MovieView movieView = new MovieView(scanner);
        TheaterView theaterView = new TheaterView(scanner);
        GradeView gradeView = new GradeView(scanner);

        theaterView.setMovieView(movieView);
        movieView.setGradeView(gradeView);
        userView.setGradeView(gradeView);
        userView.setTheaterView(theaterView);
        userView.setMovieView(movieView);

        userView.showIndex();
    }
}
