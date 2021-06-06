package com.example.Shelfish.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_EDITORA")
public class Editora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int editoraCod;
    private String editoraNm;
    private String cidade;
    private String estado;
    private String pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
