package com.daa.mvvmapp1.model;


import android.util.Log;

public class Producto {

    String nombre;
    String sku;
    Integer cantidad;
    Float costo;
    Float margen;
    Float iva;
    Float precioVenta;

    private static final String TAG = Producto.class.getSimpleName();

    //1. Solución más optimo
    public  Float getPrecioCosto(){

        try {
            //precio total de venta
            Log.d(TAG, " ******** Evento getPrecioCosto() *******+");
            return (getCostosTotales() * this.margen);
        } catch (Exception e){
            Log.i(TAG, "******** Evento Error: "+e.getMessage());
            return new Float(0);
        }
    }

    public  Float getCostosTotales(){

        try {
            // Costos = Costos fijos totales +  costos variables totales
            // Costo por unidad de producción = costos / inventario total
            Log.d(TAG, " ******** Evento getCostosTotales() +*******+");
            return (this.costo/this.cantidad);
        } catch (Exception e){
            Log.i(TAG, "******** Evento Error: "+e.getMessage());
            return new Float(0);
        }
    }

    //2. Solución menos optima

    public  static String getPrecioCosto2(String ctdInventarioProducto, String costos, String margen ){

        String precioVenta, costoProduccion;

        try {

            costoProduccion = String.valueOf(Float.parseFloat(getCosto2(ctdInventarioProducto,costos)));

            //Precio Costo de produccion
            precioVenta = String.valueOf(Double.parseDouble(costoProduccion) * Double.parseDouble(margen));
            Log.d(TAG, " ******** Evento getPrecioCosto2() +*******+");

        } catch (Exception e){
            Log.i(TAG, e.getMessage());
            return null;
        }


       return precioVenta;

    }


    public static String getCosto2(String ctdInventarioProducto, String costos ){

        String  getCostoProduccion;

        try {

        // Costos = Costos fijos totales +  costos variables totales
        // Costo por unidad de producción = costos / inventario total
        getCostoProduccion = String.valueOf(Float.parseFloat(costos)/Integer.parseInt(ctdInventarioProducto));

        Log.d(TAG, " ******** Evento getCosto2() +*******+");

        } catch (Exception e){
            Log.i(TAG, e.getMessage());
            return null;
        }

        return getCostoProduccion;

    }
    

    public Producto(String nombre, String sku, Integer cantidad, Float costo, Float margen, Float iva, Float precioVenta) {
        this.nombre = nombre;
        this.sku = sku;
        this.cantidad = cantidad;
        this.costo = costo;
        this.margen = margen;
        this.iva = iva;
        this.precioVenta = precioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Float getMargen() {
        return margen;
    }

    public void setMargen(Float margen) {
        this.margen = margen;
    }


    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Float getPrecioVenta() {
        return this.precioVenta;
    }
}