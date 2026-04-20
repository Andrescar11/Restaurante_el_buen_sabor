/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {
    
    private static final Scanner sc = new Scanner(System.in);
    private static final Datos datos = new Datos();
    
    public static void main(String[] args) {
       
   }
    
    public static void mostrarMenu(){
        
        System.out.println("\n--- SISTEMA DE GESTIÓN: " + Datos.nombreRestaurante + " ---");
        System.out.println("1. Ver Carta");
        System.out.println("2. Registrar Pedido");
        System.out.println("3. Generar Factura");
        System.out.println("4. Salir");
    }
    
    public static int leerEntero(String mensaje){
        
        System.out.println(mensaje);
        
        while (!sc.hasNextInt()) {            
            System.out.println("Por favor ingrese un numero valido: ");
        }
      return sc.nextInt();
    }
       
    private static void gestionarFacturacion(){
        
        if (!Utilidades.tieneProductoSeleccionados(datos.getMenu())) {
            System.out.println("Error: No hay productos registrados para esta mesa");
            return;
        }
        
        // Delegamos los cálculos a la clase Proceso
        double subtotal = Proceso.calcularSubtotal(datos.getMenu());
        double subtotalConDesc = Proceso.aplicarDescuento(subtotal);
        double iva = Proceso.calcularIva(subtotalConDesc);
        double total = subtotalConDesc + iva;
        
        //Delegamos la impresion a la clase imprimir
        Imprimir.imprimirCuerpoCabecera(datos.getNumeroFactura());
        Imprimir.imprimirFactura(datos.getMenu());
        Imprimir.imprimirTotales(subtotal, iva, total);
        
        //Actualizamos estado
        datos.incrementarFactura();
        Utilidades.reiniciarEstado(datos.getMenu(), datos);
        
    }
    
    private static void gestionarPedido(){
        
        int mesa = leerEntero("Ingrese numero de mesa: ");
        datos.setNumeroMesa(mesa);
        
        Imprimir.mostrarCarta(datos.getMenu());
        int item = leerEntero("Seleccione el numero del plato (0 para terminar)");
        
        while (item>0 && item <=datos.getMenu().size()) {            
            
            int cantidad = leerEntero("Cantidad: ");
            datos.getMenu().get(item-1).agregarCantidad(cantidad);
            item= leerEntero("Seleccione otro plato(0 para terminar)");
            
        }
    }
    
    public static void procesarOpcion(int opcion){
        
        switch (opcion) {
            case 1 -> Imprimir.mostrarCarta(datos.getMenu());
            case 2 -> gestionarPedido();
            case 3 -> gestionarFacturacion();
            case 4 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción no válida.");
        }
    }
    
}   
