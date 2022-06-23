package main;

import view.*;

import java.util.Scanner;

public class MovieMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserView userView = new UserView(scanner);
        MovieView movieView = new MovieView(scanner);
        TheaterView theaterView = new TheaterView(scanner);
        GradeView gradeView = new GradeView(scanner);
        TimeView timeView = new TimeView(scanner);

        theaterView.setMovieView(movieView);
        movieView.setGradeView(gradeView);
        movieView.setTimeView(timeView);
        timeView.setTheaterView(theaterView);

        userView.setTimeView(timeView);
        userView.setGradeView(gradeView);
        userView.setTheaterView(theaterView);
        userView.setMovieView(movieView);

        userView.showIndex();
    }
}
