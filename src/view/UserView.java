package view;

import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class UserView {
    private UserDTO login;
    private Scanner scanner;
    private UserController userController;
    private MovieView movieView;
    private TheaterView theaterView;
    private GradeView gradeView;

    public UserView(Scanner scanner) {
        this.scanner = scanner;
        userController = new UserController();
    }

    public void setGradeView(GradeView gradeView) {
        this.gradeView = gradeView;
    }

    public void setMovieView(MovieView movieView) {
        this.movieView = movieView;
    }

    public void setTheaterView(TheaterView theaterView) {
        this.theaterView = theaterView;
    }


    public void showIndex() {
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, "1.로그인 2.회원가입 3.종료");
            if (userChoice == 1) {
                logIn();
                /*관리자 쇼메뉴*/
                if (login != null && login.getUserGrade() == 1) {
                    showAdminMenu();
                }
                /* 일반인 쇼메뉴 */
                if (login != null) {
                    theaterView.setLogin(login);
                    movieView.setLogin(login);
                    gradeView.setLogin(login);
                    showMenu();
                }
            } else if (userChoice == 2) {
                register();
            } else if (userChoice == 3) {
                System.out.println("종료");
                break;
            }
        }
    }

    private void logIn() {
        String userid = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
        String password = ScannerUtil.nextLine(scanner, "패스워드를 입력해주세요.");
        while (userController.auth(userid, password) == null) {
            String yesNo = ScannerUtil.nextLine(scanner, "잘못입력하였습니다. 다시 로그인하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                userid = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
                password = ScannerUtil.nextLine(scanner, "패스워드를 입력해주세요.");
            } else {
                break;
            }
        }

        login = userController.auth(userid, password);
    }

    /* 일반인 */
    private void register() {
        String userId = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
        while (userController.validUserName(userId)) {
            String yesNo = ScannerUtil.nextLine(scanner, "이미 존재하는 아이디입니다. 다시 입력하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                userId = ScannerUtil.nextLine(scanner, "아이디를 입력해주세요.");
            } else {
                break;
            }
        }
        if (!userController.validUserName(userId)) {
            UserDTO u = new UserDTO();
            u.setUserId(userId);
            u.setPassword(ScannerUtil.nextLine(scanner, "비밀번호를 입력해주세요."));
            userController.insert(u);
        }
    }

    private void showMenu() {
        while (login != null) {
            int userChoice = ScannerUtil.nextInt(scanner, "1.영화정보 2.극장선택 3.로그아웃");
            if (userChoice == 1) {
                movieView.showMovieList();
            } else if (userChoice == 2) {
                theaterView.showTheaterList();
            } else if (userChoice == 3) {
                System.out.println("로그아웃 되었습니다.");
                login = null;
            }
        }

    }

    private void showAdminMenu() {
        while (login != null) {
            System.out.println("=====관리자 모드입니다=====");
            int adminChoice = ScannerUtil.nextInt(scanner, "1.영화 관련메뉴 2.극장관련 메뉴 3.회원정보 메뉴 4.로그아웃");
            if (adminChoice == 1) {
                movieView.adminMovieInfo();
            } else if (adminChoice == 2) {
                theaterView.adminTheaterInfo();
            } else if (adminChoice == 3) {
                showUserInfo();
            } else if (adminChoice == 4) {
                System.out.println("로그아웃 되었습니다.");
                login = null;
            }
        }
    }

    private void showUserInfo() {
        ArrayList<UserDTO> list = userController.selectAll();
        System.out.println("-------회원정보 리스트------");
        for (UserDTO u : list) {
            String userGrade = null;
            if (u.getUserGrade() == 1) {
                userGrade = "관리자";
            } else if (u.getUserGrade() == 2) {
                userGrade = "전문가";
            } else if (u.getUserGrade() == 3) {
                userGrade = "일반인";
            }
            System.out.printf("%s. 아이디: %s 회원등급: %s \n", u.getId(), u.getUserId(), userGrade);
        }
        int adminChoice = ScannerUtil.nextInt(scanner, "등급수정할 회원번호를 입력해주세요. * admin => 수정불가/ 뒤로가기 0");
        while (userController.selectOne(adminChoice) == null && adminChoice != 0 && adminChoice != 1) {
            String yesNo = ScannerUtil.nextLine(scanner, "잘못 입력하셨습니다. 다시 입력하시겠습니까? y/n");
            if (yesNo.equalsIgnoreCase("y")) {
                adminChoice = ScannerUtil.nextInt(scanner, "등급수정할 회원번호를 입력해주세요.");
            }
        }
        if (adminChoice == 1) {
            System.out.println("경고: 마스터 아이디입니다 해당회원은 수정불가");
        } else if (adminChoice != 0) {
            UserDTO u = userController.selectOne(adminChoice);
            int userGrade = ScannerUtil.nextInt(scanner, "수정할 회원단계 1 => 관리자 2 => 전문가 3 => 일반인", 1, 3);
            u.setUserGrade(userGrade);
            System.out.println("회원등급 수정이 완료되었습니다.");
            userController.update(u);
        }
    }
}
