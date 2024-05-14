package com.ohgiraffers.library.dao;

import com.ohgiraffers.common.JDBCTemplate;
import com.ohgiraffers.library.dto.LibraryDTO;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class LibraryRepository {

    private Properties pros = new Properties();
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;

    public LibraryRepository() {
        try {
            pros.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/library/mapper/library-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean rentBook(String bookTitle, String userName) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            con.setAutoCommit(false); // 트랜잭션 시작

            // 대여 가능한 책인지 확인
            String checkAvailabilityQuery = "SELECT * FROM book_list WHERE book_title = ? AND book_inventory = 1";
            pstmt = con.prepareStatement(checkAvailabilityQuery);
            pstmt.setString(1, bookTitle);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("해당 책은 현재 대여가 불가능합니다.");
                return false;
            }

            // 대여 처리
            String rentBookQuery = "UPDATE book_list SET book_inventory = 0 WHERE book_title = ?";
            pstmt = con.prepareStatement(rentBookQuery);
            pstmt.setString(1, bookTitle);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(userName + "님, '" + bookTitle + "' 책을 대여하였습니다.");
                con.commit(); // 커밋
                return true;
            } else {
                System.out.println("책 대여에 실패하였습니다.");
                return false;
            }
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // 롤백
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
    }


    public LibraryDTO libraryFindByBook(String name) {
        String query = pros.getProperty("libraryFindByTitle");

        con = getConnection();
        LibraryDTO lib = new LibraryDTO();

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rset = pstmt.executeQuery();
            if (rset.next()) {
                lib.setBook_number(rset.getString("book_number"));
                lib.setBook_title(rset.getString("book_title"));
                lib.setBook_author(rset.getString("book_author"));
                lib.setBook_publisher(rset.getString("Book_publisher"));
                lib.setBook_inventory(rset.getInt("Book_inventory"));
                lib.setBook_statement(rset.getString("Book_statement"));
                lib.setBook_register(rset.getString("Book_register"));
                lib.setBook_modify(rset.getString("Book_modify"));
                lib.setBook_delete(rset.getString("Book_delete"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        return lib;
    }
}