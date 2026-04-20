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
public class Utilidades {

    /**
     * Valida si el pedido contiene al menos un producto con cantidad mayor a cero.
     * Ya no limpia datos en secreto (Eliminado el Efecto Secundario).
     */

    public static boolean tieneProductoSeleccionados(List<Producto> menu){
        for (Producto producto : menu) {
            if (producto.getCantidad()>0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Reinicia todas las cantidades del menú y el estado de la mesa.
     */
    
    public static void reiniciarEstado(List<Producto> menu, Datos datos){
        for (Producto producto : menu) {
            producto.reiniciarCantidad();
        }
    }
    
    // El método calcular() con 7 parámetros ha sido ELIMINADO.
    // Esa lógica ahora pertenece a la clase Proceso o al objeto Factura.
    
}