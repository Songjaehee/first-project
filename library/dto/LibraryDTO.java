package com.ohgiraffers.library.dto;

public class LibraryDTO {

    private String book_number;
    private String book_title;
    private String book_author;
    private String book_publisher;
    private int book_inventory;
    private String book_statement;
    private String book_register;
    private String book_modify;
    private String book_delete;

    // 생성자 수정
    public LibraryDTO() {
    }

    public LibraryDTO(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_number() {
        return book_number;
    }

    public void setBook_number(String book_number) {
        this.book_number = book_number;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_publisher() {
        return book_publisher;
    }

    public void setBook_publisher(String book_publisher) {
        this.book_publisher = book_publisher;
    }

    public int getBook_inventory() {
        return book_inventory;
    }

    public void setBook_inventory(int book_inventory) {
        this.book_inventory = book_inventory;
    }

    public String getBook_statement() {
        return book_statement;
    }

    public void setBook_statement(String book_statement) {
        this.book_statement = book_statement;
    }

    public String getBook_register() {
        return book_register;
    }

    public void setBook_register(String book_register) {
        this.book_register = book_register;
    }

    public String getBook_modify() {
        return book_modify;
    }

    public void setBook_modify(String book_modify) {
        this.book_modify = book_modify;
    }

    public String getBook_delete() {
        return book_delete;
    }

    public void setBook_delete(String book_delete) {
        this.book_delete = book_delete;
    }

    @Override
    public String toString() {
        return "도서 정보 (" +
                "도서 번호 :'" + book_number + '\'' +
                ", 책 제목 : '" + book_title + '\'' +
                ", 저자 : '" + book_author + '\'' +
                ", 출판사 : '" + book_publisher + ')' + "\n";
    }
}