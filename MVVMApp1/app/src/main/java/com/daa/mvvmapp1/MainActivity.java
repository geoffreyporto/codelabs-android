package com.daa.mvvmapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//librerias base para MVVM
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

//Modelo de feature::user storie
import com.daa.mvvmapp1.model.Producto;
import com.daa.mvvmapp1.model.ProductoViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText edtProducto;
    private EditText edtCtdInventarioProducto;
    private EditText edtCtd;
    private EditText edtCosto;
    private EditText edtMargen;
    private TextView lblIVA;
    private EditText edtPrecioVenta;
    private Button btnCalcularPrecio;

    String nombre;
    String sku;
    String cantidad;
    String costo;
    String margen;
    String iva;
    String precioVenta;

    private ProductoViewModel viewModel;

    private static final String TAG = MainActivity.class.getSimpleName();

    TextWatcher tt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();
    }

    private void configView(){

        try {

            //Associando la view (Actividad o fragmento) a un ViewModel
            viewModel = ViewModelProviders.of(this).get(ProductoViewModel.class);

            //Asociando variables a componentes de la vista
            edtProducto = findViewById(R.id.edtProducto);
            edtCtdInventarioProducto = findViewById(R.id.edtCtdInventarioProducto);
            edtCtd = findViewById(R.id.edtCtd);
            lblIVA = findViewById(R.id.lblIVA);
            edtCosto = findViewById(R.id.edtCosto);
            edtMargen = findViewById(R.id.edtMargen);
            edtPrecioVenta = findViewById(R.id.edtPrecioVenta);
            btnCalcularPrecio = findViewById(R.id.btnCalcularPrecio);

            /*Log.d(TAG, "Producto: "+edtProducto);
            Log.d(TAG, "Cantidad: "+edtCtd);
            Log.d(TAG, "Iva: "+lblIVA);
            Log.d(TAG, "Costo: "+edtCosto);*/


            final Observer<Producto> observerProducto = new Observer<Producto>() {
                @Override
                public void onChanged(Producto resultado) {
                    Log.d(TAG, " ******** Evento onChanged(String resultado) +*******+");
                    edtPrecioVenta.setText(String.valueOf(resultado.getPrecioVenta()));
                    lblIVA.setText(String.valueOf(resultado.getIva()));
                }
            };

            viewModel.getPrecioVenta().observe(this, observerProducto);


            //Monitoreando los cambios de datos
            capturarCambios(edtCtdInventarioProducto);
            capturarCambios(edtCosto);
            capturarCambios(edtMargen);

            //Asociando evento clic al boton "Calcula" :: OPCIONAL
            /*btnCalcularPrecio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Evento btnCalcularPrecio.setOnClickListener()::onClick(View v)");
                    viewModel.calcularPrecioVenta( edtCtdInventarioProducto.getText().toString(), edtCosto.getText().toString(), edtMargen.getText().toString()  );
                }
            });*/


        } catch (Exception e){
            Log.i(TAG, "******** Evento Error: "+e.getMessage());
        }

    }

    boolean datosValidos(){

        if(edtCtdInventarioProducto.getText().toString().isEmpty()){
            edtCtdInventarioProducto.setText("0");
        }

        if(edtCosto.getText().toString().isEmpty()){
            edtCosto.setText("0");
        }

        if(edtMargen.getText().toString().isEmpty()){
            edtMargen.setText("0");
        }

        if ((edtCtdInventarioProducto.getText().toString().isEmpty() && edtCosto.getText().toString().isEmpty() && edtMargen.getText().toString().isEmpty())
                || ( (edtCtdInventarioProducto.getText().toString().equals("") || edtCosto.getText().toString().equals("") || edtMargen.getText().toString().equals("")) ) ) {
            return  false;
        }
        else {
            return true;
        }

    }

    void capturarCambios(final EditText edt){
        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                cantidad = (edtCtdInventarioProducto.getText().toString());
                costo = (edtCosto.getText().toString());
                margen = (edtMargen.getText().toString());

                if (datosValidos()) {
                    //viewModel.calcularPrecioVenta( edtCtdInventarioProducto.getText().toString(), edtCosto.getText().toString(), edtMargen.getText().toString()  );
                    viewModel.calcularPrecioVenta( cantidad, costo, margen );
                    Log.d(TAG, " Calculando capturarCambios().calcularPrecioVenta() ...");

                    /*viewModel.calcularIVA();
                    Log.d(TAG, " Calculando capturarCambios().calcularIVA() ...");*/

                } else{
                    //datos vacios
                    Log.d(TAG, " ******** No hay datos *******+");
                }
            }
        });
    }



    /*void capturarCambiosIVA(final TextView lbl){
        lbl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                cantidad = (edtCtdInventarioProducto.getText().toString());
                costo = (edtCosto.getText().toString());
                margen = (edtMargen.getText().toString());

                if (datosValidos()) {
                    //viewModel.calcularPrecioVenta( edtCtdInventarioProducto.getText().toString(), edtCosto.getText().toString(), edtMargen.getText().toString()  );
                    //viewModel.calcularIVA( cantidad, costo, margen );
                    viewModel.calcularIVA();
                    Log.d(TAG, " Calculando capturarCambiosIVA() ...");
                } else{
                    //datos vacios
                    Log.d(TAG, " ******** No hay datos *******+");
                }
            }
        });
    }*/

}