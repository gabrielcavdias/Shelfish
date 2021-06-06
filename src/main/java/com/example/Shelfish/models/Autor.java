package com.example.Shelfish.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="TB_AUTOR")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int autorCod;

    @NotNull
    private String autorNm;

    private String cidade;

    private String estado;

    private String pais;

    private String biografia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
