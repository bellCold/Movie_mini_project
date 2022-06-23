package view;

import controller.TimeController;
import model.TheaterDTO;
import model.TimeDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class TimeView {
    private UserDTO login;
    private Scanner scanner;
    private TimeController timeController;
    private TheaterView theaterView;

    public TimeView(Scanner scanner) {
        this.scanner = scanner;
        timeController = new TimeController();
    }

    public void setTheaterView(TheaterView theaterView) {
        this.theaterView = theaterView;
    }

    public void setLogin(UserDTO login) {
        this.login = login;
    }

    //id => 극장넘버 movieNum 영화넘버
    public void addMovieTime(int movieNum) {
        TimeDTO t = new TimeDTO();
        t.setMovieNum(movieNum);
        t.setMovieTime(ScannerUtil.nextLine(scanner, "상영시간을 입력해주세요."));
        theaterView.showTheaterList();

        t.setTheaterNum(/*theaternum*/);
        timeController.register(t);
    }
}
