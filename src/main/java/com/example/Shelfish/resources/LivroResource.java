package com.example.Shelfish.resources;

import com.example.Shelfish.models.Livro;
import com.example.Shelfish.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LivroResource {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/livro")
    public List<Livro> listaLivro(){
        List<Livro> livros = livroRepository.findAll();
        return livros;
    }

    @GetMapping("/livro/{isbn}")
    //Recebo um ISBN pela URL e devolvo somente ele
    public Livro mostrarProduto(@PathVariable(value = "isbn") String isbnUrl){
        return livroRepository.findByISBN(isbnUrl);
    }

    @PostMapping("/livro")
    public Livro guardarLivro(
            @RequestBody
            Livro livro
    ){
        return livroRepository.save(livro);
    }
    //Funciona tanto enviando o JSON inteiro quanto enviando só o ID
    @DeleteMapping("/livro")
    public void deletaLivro(
            @RequestBody
            Livro livro
    ){
        livroRepository.delete(livro);
    }

    @PutMapping("/livro")
    public Livro atualizarLivro(
            @RequestBody
            Livro livro
    ){
        return livroRepository.save(livro);
    }

}
