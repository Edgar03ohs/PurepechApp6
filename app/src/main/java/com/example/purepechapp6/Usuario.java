package com.example.purepechapp6;

public class Usuario {
    private String usuario;
    private String correo;
    private String contraseña;
    private int puntos;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Usuario(String usuario, String correo, String contraseña, int puntos) {
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.puntos = puntos;
    }


}
