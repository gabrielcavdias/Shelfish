package com.example.Shelfish.service.serviceImpl;

import com.example.Shelfish.models.Autor;
import com.example.Shelfish.repository.AutorRepository;
import com.example.Shelfish.service.ShelfishAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfishAutorServiceImpl implements ShelfishAutorService {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findbyAutorCod(int autorCod) {
        return autorRepository.findAutorByAutorCod(autorCod);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void delete(Autor autordeletado) {
        autorRepository.delete(autordeletado);
    }
}
