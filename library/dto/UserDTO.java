package com.ohgiraffers.library.dto;

public class UserDTO {

    //사용자 정보를 저장하는 클래스입니다.

    private String name;
    private int age;
    private String phone;

//  name, age, phone 3개의 필드를 가지며, 이를 생성자를 통해 초기화합니다.

    public UserDTO(){ }

    public UserDTO(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() { // toString() 메서드를 오버라이드하여 이름만 반환하도록 설정되어 있습니다.
        return "\n"+name;
    }


}
