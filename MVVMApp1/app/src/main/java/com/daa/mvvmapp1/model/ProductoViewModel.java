package com.daa.mvvmapp1.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductoViewModel extends ViewModel {


    Producto producto;

    //Tipo objeto
    private MutableLiveData<Producto> resultado;


    //Tipo string
    //private MutableLiveData<String> resultado;

    public ProductoViewModel(){
        resultado = new MutableLiveData<>();
    }

    //Tipo objeto
    public LiveData<Producto> getPrecioVenta(){return resultado;}

    //Tipo string
    //public LiveData<String> getPrecioVenta(){return resultado;}


    public  void calcularPrecioVenta(String ctdInventarioProducto, String costos, String margen){

        producto = new  Producto("", "1001", Integer.parseInt(ctdInventarioProducto),Float.parseFloat(costos),Float.parseFloat(margen),Float.parseFloat("1.16"),Float.parseFloat("0"));
        producto.setPrecioVenta(producto.getPrecioCosto());

        //Regresa Tipo objeto
        resultado.setValue(producto);

        //Regresa Tipo string
        //resultado.setValue(String.valueOf(producto.getPrecioCosto()));

        //Tipo string
        //resultado.setValue(Producto.getPrecioCosto2(ctdInventarioProducto, costos, margen));
    }


    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
