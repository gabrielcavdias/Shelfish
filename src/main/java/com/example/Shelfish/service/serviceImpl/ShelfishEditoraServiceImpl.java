package com.example.Shelfish.service.serviceImpl;

import com.example.Shelfish.models.Editora;
import com.example.Shelfish.repository.EditoraRepository;
import com.example.Shelfish.service.ShelfishEditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfishEditoraServiceImpl implements ShelfishEditoraService {
    @Autowired
    EditoraRepository editoraRepository;

    @Override
    public List<Editora> findAll() {
        return editoraRepository.findAll();
    }

    @Override
    public Editora findEditoraByEditoraCod(int editoraCod) {
        return editoraRepository.findEditoraByEditoraCod(editoraCod);
    }

    @Override
    public void delete(Editora editora) {
        editoraRepository.delete(editora);
    }

    @Override
    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }
}
