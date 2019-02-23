/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.modelos;

/**
 *
 * @author AndreGuerra
 */
public class Producto {
    private String nombre;
    private double precio;
    private int existencias;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int getExistencias() {
        return existencias;
    }

    public int isExistencias() {
        return existencias;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }    
    
    public Producto(String nombre, double precio, int existencias){
        this.nombre = nombre;
        this.precio = precio;
        this.existencias = existencias;
    }
    
    public Producto(){}
    
}
