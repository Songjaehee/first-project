package com.ohgiraffers.library.dto;

import java.util.ArrayList;
import java.util.Iterator;

public class UserRepository {

    // UserDTO 객체를 저장하고 출력하는 역할을 합니다.

    private ArrayList<UserDTO> data = new ArrayList<>();

    public void addUser(UserDTO user) { //주어진 UserDTO 객체를 리스트에 추가합니다.
        data.add(user);
    }

    public void print() {
        for (Object user : data) { // 리스트에 저장되어있는 모든 사용자 정보를 차례대로 출력합니다.
            System.out.print(user);
        }

    }

    public boolean login(String userName, String phone) {
        for (UserDTO user : data) {
            if (user.getName().equals(userName) && user.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }


    public boolean removeUser(String userName, String userPhone) {
        Iterator<UserDTO> iterator = data.iterator(); // 반복자 생성
        while (iterator.hasNext()) {
            UserDTO user = iterator.next();
            if (user.getName().equals(userName) && user.getPhone().equals(userPhone)) {
                iterator.remove(); // 현재 요소를 삭제
                return true;
            }
        }
        return false; // 해당하는 이름과 전화번호의 회원이 없을 경우
    }
}
