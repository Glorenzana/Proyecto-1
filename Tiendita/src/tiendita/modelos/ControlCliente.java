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
import tiendita.modelos.Cliente;

/**
 *
 * @author AndreGuerra
 */
public class ControlCliente {

    public static void crearArchivo(ArrayList<Cliente> listaClientes) {
        FileWriter flWriter = null;
        try {
            flWriter = new FileWriter("D:\\clientesTiendita.txt");
            BufferedWriter bfWritter = new BufferedWriter(flWriter);
            for (Cliente cliente : listaClientes) {
                bfWritter.write(cliente.getNombre() + "," + cliente.getNit() + ","
                        + cliente.getDireccion() + "," + cliente.getDeudaCredito() + "\n");
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

    public static ArrayList<Cliente> leerArchivo() {

        File file = new File("D:\\clientesTiendita.txt");
        ArrayList listaClientes = new ArrayList<Cliente>();
        Scanner scanner;
        try {
            if (file.exists()) {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*");
                    Cliente cliente = new Cliente();
                    cliente.setNombre(delimitar.next().toString());
                    cliente.setNit(delimitar.next().toString());
                    cliente.setDireccion(delimitar.next().toString());
                    cliente.setDeudaCredito(Double.parseDouble(delimitar.next()));
                    listaClientes.add(cliente);
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    public static void agregarCliente(ArrayList<Cliente> lista) {
        System.out.println("Voy agregar");
        FileWriter flwriter = null;
        try {
                flwriter = new FileWriter("D:\\clientesTiendita.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for (Cliente cliente : lista) {
                        bfwriter.write(cliente.getNombre() + "," + cliente.getNit() + "," + cliente.getDireccion() + "," + cliente.getDeudaCredito() + "\n");
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
