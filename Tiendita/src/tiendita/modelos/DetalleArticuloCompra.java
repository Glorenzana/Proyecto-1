/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.modelos;

/**
 *
 * @author USLorenzana
 */
public class DetalleArticuloCompra {
    
    private String Nit;
    private String articulo;
    private int cantidad;

    public String getNit() {
        return Nit;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleArticuloCompra(String Nit, String articulo, int cantidad) {
        this.Nit = Nit;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public DetalleArticuloCompra() {
    }

    
}
