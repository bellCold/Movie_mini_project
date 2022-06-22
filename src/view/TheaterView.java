package view;

import controller.TheaterController;
import model.TheaterDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class TheaterView {
    private Scanner scanner;
    private TheaterController theaterController;
    private UserDTO login;
    private MovieView movieView;

    public TheaterView(Scanner scanner) {
        this.scanner = scanner;
        theaterController = new TheaterController();
    }

    public void setMovieView(MovieView movieView) {
        this.movieView = movieView;
    }

    public void setLogin(UserDTO login) {
        this.login = login;
    }

    /*일반 극장 메뉴*/
    private void allTheaterInfo(int userChoice) {
        while (theaterController.selectOne(userChoice) == null && userChoice != 0) {
            String yesNo = ScannerUtil.nextLine(scanner, "선택하신 극장정보가 올바르지 않습니다. 다시선택 하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("Y")) {
                userChoice = ScannerUtil.nextInt(scanner, "1.극장 상세보기 /뒤로가기 0");
            } else {
                break;
            }
        }
        if (theaterController.selectOne(userChoice) != null) {
            printOne(userChoice);
        }
    }

    private void printOne(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        System.out.printf("%d. 극장: %s 극장 장소: %s 극장 전화번호 %s\n", t.getId(), t.getTheaterName(), t.getTheaterLocation(), t.getTheaterNumber());
        int movieListModify = ScannerUtil.nextInt(scanner, "1.해당극장 상영영화 추가 2.상영영화 삭제 3.뒤로가기");
        if (movieListModify == 1) {
            movieView.showMovieList();
        } else if (movieListModify == 2) {
        }
    }

    public void showTheaterList() {
        ArrayList<TheaterDTO> list = theaterController.selectAll();
        if (list.isEmpty()) {
            System.out.println("현재 등록된 극장이없습니다.");
        } else {
            for (TheaterDTO t : list) {
                System.out.printf("%d. 극장: %s\n", t.getId(), t.getTheaterName());
            }
            int userChoice = ScannerUtil.nextInt(scanner, "상세보기할 극장번호입력 /뒤로가기 0");
            allTheaterInfo(userChoice);
        }

    }

    /*관리자 극장 뷰*/
    public void adminTheaterInfo() {
        showTheaterList();
        int adminChoice = ScannerUtil.nextInt(scanner, "1.현재 등록된 극장보기 2.극장 등록 3.극장 수정 4.극장 삭제 5.뒤로가기");
        if (adminChoice == 1) {
            showTheaterList();
        } else if (adminChoice == 2) {
            theaterRegister();
        } else if (adminChoice == 3) {
            theaterUpdate();
        } else if (adminChoice == 4) {
            theaterDelete();
        }
    }

    private void theaterRegister() {
        TheaterDTO t = new TheaterDTO();
        t.setTheaterName(ScannerUtil.nextLine(scanner, "극장 이름을 입력해주세요."));
        t.setTheaterLocation(ScannerUtil.nextLine(scanner, "극장 장소를 입력해주세요."));
        t.setTheaterNumber(ScannerUtil.nextLine(scanner, "극장 전화번호를 입력해주세요."));
        theaterController.register(t);
    }

    private void theaterUpdate() {
        showTheaterList();
        int choiceTheater = ScannerUtil.nextInt(scanner, "수정할 극장을 선택해주세요. 뒤로가기0");
        while (choiceTheater != 0 && theaterController.selectOne(choiceTheater) == null) {
            String yesNo = ScannerUtil.nextLine(scanner, "잘못 입력하셨습니다. 다시입력하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                choiceTheater = ScannerUtil.nextInt(scanner, "수정할 극장을 선택해주세요. 뒤로가기0");
            }
        }
        if (choiceTheater != 0) {
            TheaterDTO t = theaterController.selectOne(choiceTheater);
            t.setTheaterName(ScannerUtil.nextLine(scanner, "새로운 극장 이름을 입력해주세요."));
            t.setTheaterLocation(ScannerUtil.nextLine(scanner, "새로운 극장 장소를 입력해주세요."));
            t.setTheaterNumber(ScannerUtil.nextLine(scanner, "새로운 극장 전화번호를 입력해주세요."));
            System.out.println("수정 완료!");
            theaterController.update(t);
        }
    }

    private void theaterDelete() {
        showTheaterList();
        int choiceTheater = ScannerUtil.nextInt(scanner, "삭제할 극장을 선택해주세요. 뒤로가기0");
        while (choiceTheater != 0 && theaterController.selectOne(choiceTheater) == null) {
            String yesNo = ScannerUtil.nextLine(scanner, "잘못 입력하셨습니다. 다시입력하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                choiceTheater = ScannerUtil.nextInt(scanner, "삭제할 극장을 선택해주세요. 뒤로가기0");
            }
        }
        if (choiceTheater != 0) {
            String yesNo = ScannerUtil.nextLine(scanner, "정말 삭제하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                System.out.println("삭제 완료!");
                theaterController.delete(choiceTheater);
            }
        }
    }

}
