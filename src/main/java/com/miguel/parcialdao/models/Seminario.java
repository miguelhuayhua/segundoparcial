package com.miguel.parcialdao.models;

public class Seminario {

    private int id, cupo;
    private String titulo, fecha;

    public Seminario(int id, int cupo, String titulo, String fecha) {
        this.id = id;
        this.cupo = cupo;
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public Seminario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
