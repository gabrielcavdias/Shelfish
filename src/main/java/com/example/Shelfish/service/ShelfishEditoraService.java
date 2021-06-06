package com.example.Shelfish.service;

import com.example.Shelfish.models.Autor;
import com.example.Shelfish.models.Editora;

import java.util.List;

public interface ShelfishEditoraService {
    List<Editora> findAll();

    Editora findEditoraByEditoraCod(int editoraCod);

    void delete(Editora editora);

    Editora save(Editora editora);
}
