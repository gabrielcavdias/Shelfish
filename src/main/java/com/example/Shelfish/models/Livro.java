package com.example.Shelfish.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
/*Talvez não use serializable*/

@Entity
@Table(name="TB_LIVRO")
public class Livro implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ISBN;

    private String titulo;

    private String genero;
    /*Foreign Key*/
    private int autorCod;

    private String autorNm;
    /*Foreign Key*/
    private int editoraCod;

    private String editoraNm;

    private BigDecimal preco;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAutorCod() {
        return autorCod;
    }

    public void setAutorCod(int autorCod) {
        this.autorCod = autorCod;
    }

    public String getAutorNm() {
        return autorNm;
    }

    public void setAutorNm(String autorNm) {
        this.autorNm = autorNm;
    }

        public int getEditoraCod() {
        return editoraCod;
    }

    public void setEditoraCod(int editoraCod) {
        this.editoraCod = editoraCod;
    }

    public String getEditoraNm() {
        return editoraNm;
    }

    public void setEditoraNm(String editoraNm) {
        this.editoraNm = editoraNm;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
