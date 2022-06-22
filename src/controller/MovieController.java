package controller;

import model.MovieDTO;

import java.util.ArrayList;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;

    public MovieController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public ArrayList<MovieDTO> selectAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO m : list) {
            temp.add(new MovieDTO(m));
        }
        return temp;
    }

    public MovieDTO selectOne(int id) {
        for (MovieDTO m : list) {
            if (m.getId() == id) {
                return new MovieDTO(m);
            }
        }
        return null;
    }

    public void register(MovieDTO m) {
        m.setId(nextId++);
        list.add(m);
    }

    public void update(MovieDTO m) {
        int index = list.lastIndexOf(m);
        list.set(index, m);
    }

    public void delete(int id) {
        list.remove(new MovieDTO(id));
    }
}
