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
public class Proceso {

    /**
     * Calcula el subtotal sumando el (precio * cantidad) de cada producto.
     */

    public static double calcularSubtotal(List<Producto> productos){
        
        double subtotal=0;
        
        for (Producto producto : productos) {
            subtotal += producto.getCantidad()*producto.getPrecio();
        }
        return subtotal;
    }
    
      /**
     * Aplica un descuento si el subtotal supera el umbral definido.
     */
    
    public static double aplicarDescuento(double subtotal){
        
        if (subtotal>Datos.umbralDescuento) {
            return subtotal*0.95;
        }
        return subtotal;
    }
    
}