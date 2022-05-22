package com.example.cotizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNumeroDeCotizacion;
    private EditText txtDescripcion;
    private EditText txtPrecio;
    private EditText txtPorcentajePagoInicial;
    private EditText txtPlazo;
    private TextView lblDatos;

    private Button btnIntroducirDatos;
    private Button btnMostrarDatos;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumeroDeCotizacion = (EditText) findViewById(R.id.txtNumeroDeCotizacion);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtPorcentajePagoInicial = (EditText) findViewById(R.id.txtPorcentajePagoInicial);
        txtPlazo = (EditText) findViewById(R.id.txtPlazo);
        lblDatos = (TextView) findViewById(R.id.lblDatos);

        btnIntroducirDatos = (Button) findViewById(R.id.btnIntroducirDatos);
        btnMostrarDatos = (Button) findViewById(R.id.btnMostrarDatos);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        Cotizacion cotizacion = new Cotizacion();

        btnIntroducirDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numeroDeCotizacion = txtNumeroDeCotizacion.getText().toString();
                cotizacion.setNumeroCotizacion(Integer.parseInt(numeroDeCotizacion));

                cotizacion.setDescripcionAutomovil(txtDescripcion.getText().toString());

                String precio = txtPrecio.getText().toString();
                cotizacion.setPrecio(Double.parseDouble(precio));

                String porcentajePagoInicial = txtPorcentajePagoInicial.getText().toString();
                cotizacion.setPorcentajePagoInicial(Double.parseDouble(porcentajePagoInicial));

                String plazo = txtPlazo.getText().toString();
                cotizacion.setPlazo(Integer.parseInt(plazo));

                Toast.makeText(MainActivity.this, "Datos guardados", Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNumeroDeCotizacion.setVisibility(View.GONE);
                txtDescripcion.setVisibility(View.GONE);
                txtPrecio.setVisibility(View.GONE);
                txtPorcentajePagoInicial.setVisibility(View.GONE);
                txtPlazo.setVisibility(View.GONE);
                btnIntroducirDatos.setVisibility(View.GONE);
                btnMostrarDatos.setVisibility(View.GONE);
                btnRegresar.setVisibility(View.VISIBLE);

                Double pagoInicial = cotizacion.sacarPagoInicial();
                Double pagoFinal = cotizacion.sacarTotalFinal();
                Double pagoMensual = cotizacion.sacarPagoMensual();

                lblDatos.setText("Número de cotización: " +cotizacion.getNumeroCotizacion()
                +"\n\nDescripción: " +cotizacion.getDescripcionAutomovil()
                +"\n\nPrecio: " +cotizacion.getPrecio()
                +"\n\nPorcentaje de pago inicial (%): " +cotizacion.getPorcentajePagoInicial()
                +"\n\nPlazo (en meses): " +cotizacion.getPlazo()
                +"\n\n\nPago inicial: " + pagoInicial
                +"\n\nTotal a fin: " +pagoFinal
                +"\n\nPago mensual: " +pagoMensual);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblDatos.setText("");

                txtNumeroDeCotizacion.setText("");
                txtDescripcion.setText("");;
                txtPrecio.setText("");
                txtPorcentajePagoInicial.setText("");
                txtPlazo.setText("");

                txtNumeroDeCotizacion.setVisibility(View.VISIBLE);
                txtDescripcion.setVisibility(View.VISIBLE);
                txtPrecio.setVisibility(View.VISIBLE);
                txtPorcentajePagoInicial.setVisibility(View.VISIBLE);
                txtPlazo.setVisibility(View.VISIBLE);
                btnIntroducirDatos.setVisibility(View.VISIBLE);
                btnMostrarDatos.setVisibility(View.VISIBLE);
                btnRegresar.setVisibility(View.GONE);
            }
        });

    }
}