package co.edu.uniquindio.poo.model;

/**
 * Esta clase representa una habitación del Hotel
 * @version 1.0
 * @author Esteban Vega Sanchez y Jeronimo Aristizabal Vanegas
 * @fecha: 24/09/2026
 */

public class Habitacion {

    private byte estado;
    private int numero;
    private byte tipo;
    private byte piso;
    private double precio;
    private byte capacidad;

    public Habitacion(byte estado, int numero, byte tipo, byte piso, double precio, byte capacidad) {
        this.estado = estado;
        this.numero = numero;
        this.tipo=tipo;
        this.piso=piso;
        this.precio=precio;
        this.capacidad=capacidad;

    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "estado=" + estado +
                ", numero=" + numero +
                ", tipo=" + tipo +
                ", piso=" + piso +
                ", precio=" + precio +
                ", capacidad=" + capacidad +
                '}';
    }
}