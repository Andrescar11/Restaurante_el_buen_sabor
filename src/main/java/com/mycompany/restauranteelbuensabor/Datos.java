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
public class Datos {

    //constantes para evitar hardcodeo
    public static final String nombreRestaurante = "Restaurante El Buen Sabor";
    public static final String NIT = "900.123.456-7";
    public static final double ivaPorcentaje = 0.19;
    public static final double umbralDescuento = 50000;
    
    //lista de objetos para evitar uso de arreglos paralelos
    private List<Producto> menu;
    private int numeroMesa;
    private int numeroFactura;
    private boolean mesaActiva;
    
    // Agregamos todos los productos basados en los arrays originales
    private void inicializarMenu() {
        menu.add(new Producto("Bandeja Paisa", 32000));
        menu.add(new Producto("Sancocho de Gallina", 28000));
        menu.add(new Producto("Arepa con Huevo", 8000));
        menu.add(new Producto("Jugo Natural", 7000));
        menu.add(new Producto("Gaseosa", 4500));
        menu.add(new Producto("Cerveza Poker", 6000));
        menu.add(new Producto("Agua Panela", 3500));
        menu.add(new Producto("Arroz con Pollo", 25000));
    }
}