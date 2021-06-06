package com.example.Shelfish.service.serviceImpl;

import com.example.Shelfish.models.Livro;
import com.example.Shelfish.repository.LivroRepository;
import com.example.Shelfish.service.ShelfishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShelfishServiceImpl implements ShelfishService {
    @Autowired
    LivroRepository livroRepository;

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Livro findbyISBN(String isbn) {
        return livroRepository.findByISBN(isbn);
    }

    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void delete(Livro livroDeletado) {
        livroRepository.delete(livroDeletado);
    }
}
