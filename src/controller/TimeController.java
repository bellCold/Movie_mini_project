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

    public void register(TimeDTO t) {
        t.setId(nextId++);
        list.add(t);
    }
}
