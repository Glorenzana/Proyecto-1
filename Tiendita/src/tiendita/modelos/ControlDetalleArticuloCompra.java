/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendita.modelos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import tiendita.modelos.DetalleArticuloCompra;

/**
 *
 * @author USLorenzana
 */
public class ControlDetalleArticuloCompra {

    public static void crearArchivo(ArrayList<DetalleArticuloCompra> listaDetalle) {
        FileWriter flWriter = null;
        try {
            flWriter = new FileWriter("D:\\DetalleArticuloCompra.txt");
            BufferedWriter bfWritter = new BufferedWriter(flWriter);
            for (DetalleArticuloCompra detalle : listaDetalle) {
                bfWritter.write(detalle.getNit() + "," + detalle.getArticulo() + ","
                        + detalle.getCantidad() + "\n");
                bfWritter.close();
                System.out.println("Creado Correctamente");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flWriter != null) {
                try {//cierra el flujo principal
                    flWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<DetalleArticuloCompra> leerArchivo() {

        File file = new File("D:\\DetalleArticuloCompra.txt");
        ArrayList listaDetalle = new ArrayList<DetalleArticuloCompra>();
        Scanner scanner;
        try {
            if (file.exists()) {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*");
                    DetalleArticuloCompra detalle = new DetalleArticuloCompra();
                    detalle.setNit(delimitar.next().toString());
                    detalle.setArticulo(delimitar.next().toString());
                    detalle.setCantidad(Integer.parseInt(delimitar.next()));
                    listaDetalle.add(detalle);
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaDetalle;
    }

    public static void agregarDetalleCompra(ArrayList<DetalleArticuloCompra> lista) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("D:\\DetalleArticuloCompra.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (DetalleArticuloCompra detalle : lista) {
                bfwriter.write(detalle.getNit() + "," + detalle.getArticulo() + "," + detalle.getCantidad() + "\n");
            }
            bfwriter.close();
            System.out.println("Modificado Correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
