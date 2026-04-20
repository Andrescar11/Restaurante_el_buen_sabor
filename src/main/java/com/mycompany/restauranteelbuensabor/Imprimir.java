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
    
}