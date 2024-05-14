package com.ohgiraffers.library.service;

import com.ohgiraffers.library.dao.LibraryRepository;
import com.ohgiraffers.library.dto.LibraryDTO;

import java.sql.SQLException;

public class LibraryService {

    private LibraryRepository libraryRepository;

    public LibraryService() {
        this.libraryRepository = new LibraryRepository();
    }

    public LibraryDTO libraryFindByBook(String name) {
        if(name == null || name.equals("")) {
            return null;
        }
        return libraryRepository.libraryFindByBook(name);
    }

}