package controller;

import model.TimeDTO;

import java.util.ArrayList;

public class TimeController {
    private ArrayList<TimeDTO> list;
    private int nextId;

    public TimeController() {
        list = new ArrayList<>();
        nextId = 1;
    }
}
