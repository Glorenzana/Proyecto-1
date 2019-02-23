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
import tiendita.modelos.Producto;

/**
 *
 * @author AndreGuerra
 */
public class ControlProductos {
    public static void crearArchivo(ArrayList<Producto> listaProducto){
        FileWriter flWriter = null;
        try{
            flWriter = new FileWriter("D:\\productos.txt");
            BufferedWriter bfWritter = new BufferedWriter(flWriter);
            for (Producto producto : listaProducto){
                bfWritter.write(producto.getNombre() + "," + producto.getPrecio() + "," +
                        producto.getExistencias()+ "\n");
                bfWritter.close();
                System.out.println("Creado Correctamente");               
            }
        }catch(IOException e){
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
    
    public static ArrayList<Producto> leerArchivo() {

        File file = new File("D:\\productos.txt");
        ArrayList listaProductos= new ArrayList<Producto>();	
        Scanner scanner;
        try {
            if(file.exists()){
                scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);		
                delimitar.useDelimiter("\\s*,\\s*");
                Producto prod = new Producto();
                prod.setNombre(delimitar.next().toString());
                prod.setPrecio(Double.parseDouble(delimitar.next()));
                prod.setExistencias(Integer.parseInt(delimitar.next()));
                listaProductos.add(prod);
            }   
                    scanner.close();
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
        return listaProductos;
    }
    
    public static void agregarProducto(ArrayList<Producto> lista) {
        System.out.println("Voy agregar");
        FileWriter flwriter = null;
        try {
                flwriter = new FileWriter("D:\\productos.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                for (Producto producto : lista) {
                        bfwriter.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getExistencias()+ "\n");
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
