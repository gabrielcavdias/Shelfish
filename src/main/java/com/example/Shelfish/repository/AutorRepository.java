package com.example.Shelfish.repository;

import com.example.Shelfish.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
    //Procurar Autor por código

    Autor findAutorByAutorCod(int autorCod);

}
