package com.example.purepechapp6.traducciones;

public class EntidadAnimales {

    private int imgAnimales;
    private String titulos;
    private int imgTraduccion;

    public EntidadAnimales(int imgAnimales, String titulos, int imgTraduccion){
        this.imgAnimales = imgAnimales;
        this.imgTraduccion = imgTraduccion;
        this.titulos = titulos;
    }

    public int getImgAnimales(){return imgAnimales;}
    public int getImgTraduccion(){return imgTraduccion;}
    public String getTitulos(){return titulos;}
}
