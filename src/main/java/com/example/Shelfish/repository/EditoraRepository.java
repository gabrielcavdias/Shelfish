package com.example.Shelfish.repository;

import com.example.Shelfish.models.Editora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, String> {

    //Procurar editora por código

    Editora findEditoraByEditoraCod(int editoraCod);
}
