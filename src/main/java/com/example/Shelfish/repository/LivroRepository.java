package com.example.Shelfish.repository;

import com.example.Shelfish.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Repository Faz a ligação com o banco de dados usando o JPA
public interface LivroRepository extends JpaRepository<Livro, String> {
    //Procurar livro por ISBN

    Livro findByISBN(String isbn);

}
