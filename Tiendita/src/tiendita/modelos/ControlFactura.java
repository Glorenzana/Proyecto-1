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
import tiendita.modelos.Factura;

/**
 *
 * @author AndreGuerra
 */
public class ControlFactura {

    public static void crearArchivo(ArrayList<Factura> listaFactura) {
        FileWriter flWriter = null;
        try {
            flWriter = new FileWriter("D:\\factura.txt");
            BufferedWriter bfWritter = new BufferedWriter(flWriter);
            for (Factura factura : listaFactura) {
                bfWritter.write(factura.getNit() + "," + factura.getFormaPago() + ","
                        + factura.getTotal() + "\n");
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

    public static ArrayList<Factura> leerArchivo() {

        File file = new File("D:\\factura.txt");
        ArrayList listaFactura = new ArrayList<Factura>();
        Scanner scanner;
        try {
            if (file.exists()) {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*");
                    Factura fact = new Factura();
                    fact.setNit(delimitar.next().toString());
                    fact.setFormaPago((delimitar.next()));
                    fact.setTotal(Double.parseDouble(delimitar.next()));
                    listaFactura.add(fact);
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaFactura;
    }

    public static void agregarFactura(ArrayList<Factura> lista) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("D:\\factura.txt", true);
            BufferedWriter bfwriter = new BufferedWriter(flwriter);
            for (Factura factura : lista) {
                bfwriter.write(factura.getNit() + "," + factura.getFormaPago() + "," + factura.getTotal() + "\n");
            }
            bfwriter.close();

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
