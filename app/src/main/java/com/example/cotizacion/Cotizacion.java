package com.example.cotizacion;

import java.util.concurrent.atomic.DoubleAdder;

public class Cotizacion {
        //Atributos
        private int numeroCotizacion;
        private String descripcionAutomovil;
        private double precio;
        private double porcentajePagoInicial;
        private int plazo;

        private double pagoInicial;
        private double pagoFinal;
        private double pagoMensual;

        //Constructores
        //Constructor vacio
        Cotizacion() {
            this.numeroCotizacion = 0;
            this.descripcionAutomovil = "";
            this.precio = 0.0;
            this.porcentajePagoInicial = 0.0;
            this.plazo = 0;
        }

        //Constructor de parametros
        Cotizacion(int numeroCotizacion, String descripcionAutomovil, double precio, double porcentajePagoInicial, int plazo) {
            this.numeroCotizacion = numeroCotizacion;
            this.descripcionAutomovil = descripcionAutomovil;
            this.precio = precio;
            this.porcentajePagoInicial = porcentajePagoInicial;
            this.plazo = plazo;
        }

        //Constructor de copia
        Cotizacion(Cotizacion costo) {
            this.numeroCotizacion = costo.numeroCotizacion;
            this.descripcionAutomovil = costo.descripcionAutomovil;
            this.precio = costo.precio;
            this.porcentajePagoInicial = costo.porcentajePagoInicial;
            this.plazo = costo.plazo;
        }

        /**
         * @return the numeroCotizacion
         */
        public int getNumeroCotizacion() {
            return numeroCotizacion;
        }

        /**
         * @param numeroCotizacion the numeroCotizacion to set
         */
        public void setNumeroCotizacion(int numeroCotizacion) {
            this.numeroCotizacion = numeroCotizacion;
        }

        /**
         * @return the descripcionAutomovil
         */
        public String getDescripcionAutomovil() {
            return descripcionAutomovil;
        }

        /**
         * @param descripcionAutomovil the descripcionAutomovil to set
         */
        public void setDescripcionAutomovil(String descripcionAutomovil) {
            this.descripcionAutomovil = descripcionAutomovil;
        }

        /**
         * @return the precio
         */
        public double getPrecio() {
            return precio;
        }

        /**
         * @param precio the precio to set
         */
        public void setPrecio(double precio) {
            this.precio = precio;
        }

        /**
         * @return the porcentajePagoInicial
         */
        public double getPorcentajePagoInicial() {
            return porcentajePagoInicial;
        }

        /**
         * @param porcentajePagoInicial the porcentajePagoInicial to set
         */
        public void setPorcentajePagoInicial(double porcentajePagoInicial) {
            this.porcentajePagoInicial = porcentajePagoInicial;
        }

        /**
         * @return the plazo
         */
        public int getPlazo() {
            return plazo;
        }

        /**
         * @param plazo the plazo to set
         */
        public void setPlazo(int plazo) {
            this.plazo = plazo;
        }


        //Funciones
        public Double sacarPagoInicial() {
            pagoInicial = precio * (porcentajePagoInicial  / 100);
            return pagoInicial;
        }

        public Double sacarTotalFinal() {
            pagoFinal = precio - pagoInicial;
            return pagoFinal;
        }

        public Double sacarPagoMensual() {
            pagoMensual = pagoFinal / plazo;
            return pagoMensual;
        }
    }

