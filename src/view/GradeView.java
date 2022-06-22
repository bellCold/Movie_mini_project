package view;

import controller.GradeController;
import model.GradeDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeView {
    private Scanner scanner;
    private GradeController gradeController;
    private UserDTO login;

    private final int ADMIN = 1;
    private final int EXPERT = 2;
    private final int PUBLIC = 3;

    public GradeView(Scanner scanner) {
        this.scanner = scanner;
        gradeController = new GradeController();
    }

    public void setLogin(UserDTO login) {
        this.login = login;
    }

    /*해당 영화 평점 보기*/
    public void printGrade() {
        ArrayList<GradeDTO> list = gradeController.selectAll();
        int totalScore = 0;
        int member = list.size();
        for (GradeDTO g : list) {
            totalScore += g.getMovieAvgScore();
        }
        double avg = (double) totalScore / member;

        System.out.printf("영화전체 평점: %.1f점\n", avg);

        for (GradeDTO g : list) {
            if (g.getMovieReview() != null) {
                System.out.printf("전문가 평론: %s\n", g.getMovieReview());
            } else if (g.getMovieReview() == null) {
                System.out.println("현재 등록된 전문가 평론이 없습니다.");
            }
        }
        int expertScore = 0;
        int i = 0;
        for (GradeDTO g : list) {
            expertScore += g.getExpertScore();
            i++;
        }
        double expertAvg = (double) expertScore / i;
        System.out.printf("전문가 평점: %.1f점\n", expertAvg);

    }

    /*평점주기*/
    public void gradeRegister() {
        GradeDTO g = new GradeDTO();
        int score = ScannerUtil.nextInt(scanner, "점수를 입력해주세요.1~5점", 1, 5);
        g.setMovieAvgScore(score);
        g.setExpertScore(score);
        if (login.getUserGrade() == EXPERT) {
            g.setMovieReview(ScannerUtil.nextLine(scanner, "평론을 남겨주세요"));
        }
        g.setWriterId(login.getUserId());
        gradeController.register(g);
    }

}
