package controller;

import model.GradeDTO;

import java.util.ArrayList;

public class GradeController {
    private ArrayList<GradeDTO> list;
    private int nextId;

    public GradeController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(GradeDTO g) {
        g.setId(nextId++);
        list.add(g);
    }
}
