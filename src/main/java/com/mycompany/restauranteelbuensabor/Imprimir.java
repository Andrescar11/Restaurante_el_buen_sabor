/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.List;

/**
 *
 * @author alfre
 */
public class Imprimir {

    //Constantes para evitar repetición de formatos printf
    
    private static final String formatoFila = "%-20s x%-6d $%,.0f%n";
    private static final String separador = "========================================";
    private static final String lineaSimple = "----------------------------------------";

    public static void mostrarCarta(List<Producto> menu){

        System.out.println(separador);
        System.out.println("   " + Datos.nombreRestaurante.toUpperCase());
        System.out.println("   --- NUESTRA CARTA ---");
        System.out.println(separador);

        for (int i = 0; menu.size() < 10; i++) {
            Producto p = menu.get(i);
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), p.getNombre(), p.getPrecio());
        }
    }
    
     public static void mostrarPedido(List<Producto> menu){

        System.out.println("\n--- PEDIDO ACTUAL ---");
        double subtotal = 0;

        for (Producto producto : menu) {

            if (producto.getCantidad()>0) {
                double parcial = producto.getCantidad() * producto.getPrecio();
                System.out.printf(formatoFila, producto.getNombre(), producto.getCantidad(), parcial);
                subtotal+=parcial;
            }

        }
        System.out.println(lineaSimple);
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }
     
     public static void imprimirCuerpoCabecera(int numeroFactura){
        
        System.out.println(separador);
        System.out.println("    " + Datos.nombreRestaurante);
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println(separador);
        System.out.printf("FACTURA No. %03d%n", numeroFactura);
        System.out.println(lineaSimple); 
        
    }
     
    public static void imprimirFactura(List<Producto> menu){
        
        for (Producto producto : menu) {
            if (producto.getCantidad()>0) {
                double parcial = producto.getPrecio() * producto.getCantidad();
                System.out.printf(formatoFila, producto.getNombre(),producto.getCantidad(),parcial);
            }
        }
    }
    
    
}