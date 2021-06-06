package com.example.Shelfish.service;

import com.example.Shelfish.models.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShelfishService {
    List<Livro> findAll();

    Livro findbyISBN(String isbn);

    Livro save(Livro livro);

    void delete(Livro livroDeletado);
}
