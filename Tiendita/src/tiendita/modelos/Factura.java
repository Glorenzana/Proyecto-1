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
public class Factura {
    private String nit;
    private String formaPago;
    private double total;

    public String getNit() {
        return nit;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public double getTotal() {
        return total;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura(String nit, String formaPago, double total) {
        this.nit = nit;
        this.formaPago = formaPago;
        this.total = total;
    }

    public Factura() {
    }
        
}
