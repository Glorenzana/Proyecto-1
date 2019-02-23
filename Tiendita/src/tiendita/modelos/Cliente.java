/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.modelos;

/**
 *
 * @author Gerber
 */
public class Cliente {
    private String nombre;
    private String nit;
    private String direccion;
    private double deudaCredito;

    public double getDeudaCredito() {
        return deudaCredito;
    }

    public void setDeudaCredito(double deudaCredito) {
        this.deudaCredito = deudaCredito;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



    public Cliente(String nombre, String nit, String direccion, double credito) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.deudaCredito = credito;

    }     
    public Cliente() {}
}
