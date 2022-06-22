package controller;

import model.UserDTO;

import java.util.ArrayList;


public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;

    /*
    등급 Num
    1 -> 관리자
    2 -> 전문가
    3 -> 일반인
    */
    private final int ADMIN = 1;
    private final int EXPERT = 2;
    private final int PUBLIC = 3;

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;
        UserDTO u = new UserDTO();
        /* 관리자 */
        u.setUserId("admin");
        u.setPassword("master");
        u.setUserGrade(ADMIN);
        u.setId(nextId);
        list.add(u);
        nextId++;
    }

    //저장
    public void insert(UserDTO u) {
        /*초기 유저 등급 => PUBLIC */
        u.setUserGrade(PUBLIC);
        u.setId(nextId++);
        list.add(u);
    }

    //아이디 중복체크
    public boolean validUserName(String userId) {
        for (UserDTO u : list) {
            if (u.getUserId().equalsIgnoreCase(userId)) {
                return true;
            }
        }
        return false;
    }

    //일치회원 체크
    public UserDTO auth(String userId, String userpassword) {
        for (UserDTO u : list) {
            if (u.getUserId().equalsIgnoreCase(userId) && u.getPassword().equals(userpassword)) {
                return new UserDTO(u);
            }
        }
        return null;
    }

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {
            temp.add(new UserDTO(u));
        }
        return temp;
    }

    public UserDTO selectOne(int id) {
        for (UserDTO u : list) {
            if (u.getId() == id) {
                return new UserDTO(u);
            }
        }
        return null;
    }

    public void update(UserDTO u) {
        int index = list.lastIndexOf(u);
        list.set(index, u);
    }
}
