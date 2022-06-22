package view;

import controller.GradeController;
import controller.MovieController;
import model.MovieDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieView {
    private Scanner scanner;
    private MovieController movieController;
    private GradeView gradeView;
    private UserDTO login;

    private final int ADMIN = 1;
    private final int EXPERT = 2;
    private final int PUBLIC = 3;

    public void setLogin(UserDTO login) {
        this.login = login;
    }

    public MovieView(Scanner scanner) {
        this.scanner = scanner;
        movieController = new MovieController();
    }

    public void setGradeView(GradeView gradeView) {
        this.gradeView = gradeView;
    }

    /* 일반인 영화관련 출력*/
    /*영화 전체 출력*/
    public void allMovieInfo() {
        int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 영화번호입력 / 뒤로가기 0");
        while (movieController.selectOne(userChoice) == null && userChoice != 0) {
            userChoice = ScannerUtil.nextInt(scanner, "해당 영화가 없습니다. 다시 선택해주세요. / 뒤로가기 0");
        }
        if (userChoice != 0) {
            printMovieInfo(userChoice);
        }
    }

    private void printMovieInfo(int userChoice) {
        MovieDTO m = movieController.selectOne(userChoice);
        String Grade = null;
        if (m.getMovieGrade() == 1) {
            Grade = "<전체관람>";
        } else if (m.getMovieGrade() == 2) {
            Grade = "<15세이상>";
        } else if (m.getMovieGrade() == 3) {
            Grade = "<청불>";
        }
        System.out.printf("%d. 영화 제목: %s \n", m.getId(), m.getMovieName());
        System.out.printf("영화 등급: %s \n", Grade);
        System.out.printf("영화 줄거리: %s \n", m.getMovieSummary());
        /* 해당 영화 평점보기 */
        int choice = ScannerUtil.nextInt(scanner, "1.해당영화 평점보기 2.해당영화 평점주기 3.뒤로가기");
        if (choice == 1) {
            gradeView.printGrade();
        } else if (choice == 2) {
            gradeView.gradeRegister();
        }
    }

    /* 관리자 영화관련 출력*/
    public void adminMovieInfo() {
        int adminChoice = ScannerUtil.nextInt(scanner, "1.영화 리스트보기 2.영화 등록 3.영화 수정 4. 영화 삭제 5.뒤로가기");
        if (adminChoice == 1) {
            showMovieList();
        } else if (adminChoice == 2) {
            movieRegister();
        } else if (adminChoice == 3) {
            movieUpdate();
        } else if (adminChoice == 4) {
            movieDelete();
        }
    }

    private void movieRegister() {
        MovieDTO m = new MovieDTO();
        m.setMovieName(ScannerUtil.nextLine(scanner, "영화제목을 입력해주세요."));
        m.setMovieGrade(ScannerUtil.nextInt(scanner, "영화등급을 설정해주세요. 1.<전체관람> 2.<15세이상> 3.<청불>",1,3));
        m.setMovieSummary(ScannerUtil.nextLine(scanner, "영화 줄거리를 입력해주세요."));
        movieController.register(m);
    }

    /* 현재 영화 리스트 */
    public void showMovieList() {
        ArrayList<MovieDTO> list = movieController.selectAll();
        if (list.isEmpty()) {
            System.out.println("현재 영화 정보가없습니다.");
        } else {
            System.out.println("-------영화 리스트--------");
            for (MovieDTO m : list) {
                System.out.println(m.getId() + ". " + m.getMovieName());
            }
            if (login.getUserGrade() != ADMIN) {
                allMovieInfo();
            } else {

            }

        }
    }

    private void movieUpdate() {
        showMovieList();
        int adminChoice = ScannerUtil.nextInt(scanner, "수정할 영화를 선택해주세요. / 뒤로가기 0");
        while (adminChoice != 0 && movieController.selectOne(adminChoice) == null) {
            adminChoice = ScannerUtil.nextInt(scanner, "해당 영화가 없습니다. 다시선택해주세요 / 뒤로가기 0");
        }
        if (adminChoice != 0) {
            MovieDTO m = movieController.selectOne(adminChoice);
            m.setMovieName(ScannerUtil.nextLine(scanner, "새로운 영화제목을 입력해주세요."));
            m.setMovieGrade(ScannerUtil.nextInt(scanner, "새로운 영화등급을 설정해주세요. 1.<전체관람> 2.<15세이상> 3.<청불>",1,3));
            m.setMovieSummary(ScannerUtil.nextLine(scanner, "새로운 영화 줄거리를 입력해주세요."));
            System.out.println("수정이 완료되었습니다!");
            movieController.update(m);
        }
    }

    private void movieDelete() {
        int adminChoice = ScannerUtil.nextInt(scanner, "삭제할 영화를 선택해주세요. / 뒤로가기 0");
        while (adminChoice != 0 && movieController.selectOne(adminChoice) == null) {
            adminChoice = ScannerUtil.nextInt(scanner, "해당 영화가 없습니다. 다시선택해주세요 / 뒤로가기 0");
        }
        if (adminChoice != 0) {
            movieController.delete(adminChoice);
            System.out.println("삭제가 완료되었습니다.");
        }
    }

}

