package com.example.Shelfish.service;

import com.example.Shelfish.models.Autor;
import com.example.Shelfish.models.Livro;

import java.util.List;

public interface ShelfishAutorService {
    List<Autor> findAll();

    Autor findbyAutorCod(int autorCod);

    Autor save(Autor autor);

    void delete(Autor autordeletado);
}
