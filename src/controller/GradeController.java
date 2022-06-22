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

    public void register(GradeDTO g) {
        g.setId(nextId++);
        list.add(g);
    }

    public ArrayList<GradeDTO> selectAll() {
        ArrayList<GradeDTO> temp = new ArrayList<>();
        for (GradeDTO g : list) {
            temp.add(new GradeDTO(g));
        }
        return temp;
    }
}
