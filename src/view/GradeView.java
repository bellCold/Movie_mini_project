package view;


import controller.GradeController;
import controller.MovieController;
import model.MovieDTO;

import java.util.Scanner;

public class GradeView {
    private Scanner scanner;
    private GradeController gradeController;

    public GradeView(Scanner scanner){
        this.scanner = scanner;
        gradeController = new GradeController();
    }

    public void printGrade(int userChoice) {

    }

}
