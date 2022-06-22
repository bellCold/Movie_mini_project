package controller;

import model.TheaterDTO;

import java.util.ArrayList;

public class TheaterController {
    private ArrayList<TheaterDTO> list;
    private int nextId;

    public TheaterController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public ArrayList<TheaterDTO> selectAll() {
        ArrayList<TheaterDTO> temp = new ArrayList<>();
        for (TheaterDTO t : list) {
            temp.add(new TheaterDTO(t));
        }
        return temp;
    }

    public TheaterDTO selectOne(int id) {
        for (TheaterDTO t : list) {
            if (t.getId() == id) {
                return new TheaterDTO(t);
            }
        }
        return null;
    }

    public void register(TheaterDTO t) {
        t.setId(nextId++);
        list.add(t);
    }

    public void update(TheaterDTO t) {
        int index = list.lastIndexOf(t);
        list.set(index, t);
    }

    public void delete(int id) {
        list.remove(new TheaterDTO(id));
    }
}
