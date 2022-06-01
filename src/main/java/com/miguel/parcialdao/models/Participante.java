package com.miguel.parcialdao.models;

public class Participante {

    private int id, id_seminario, confirmado;
    private String nombres, apellidos;
    private Seminario seminario;

    public Participante(int id, int id_seminario, int confirmado, String nombres, String apellidos) {
        this.id = id;
        this.id_seminario = id_seminario;
        this.confirmado = confirmado;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Seminario getSeminario() {
        return this.seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
