package co.edu.uniquindio.poo.model;

/**
 * Esta clase representa una reserva del huesped
 * @version 1.0
 * @author Esteban Vega Sanchez y Jeronimo Aristizabal Vanegas
 * @fecha: 24/09/2026
 */

import java.util.ArrayList;

public class Reserva {

    private int codigo;
    private byte fecha;
    private byte noches;
    private byte huespedes;
    private byte estado;
    private byte pago;
    private double total;

    private Huesped ownedByHuesped;
    private int numeroHabitacion;


    public Reserva(int codigo, byte fecha, byte noches, byte huespedes, byte estado, byte pago, Huesped ownedByHuesped) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.noches = noches;
        this.huespedes = huespedes;
        this.estado = estado;
        this.pago = pago;

        this.numeroHabitacion=numeroHabitacion;
        this.ownedByHuesped=ownedByHuesped;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public byte getFecha() {
        return fecha;
    }

    public void setFecha(byte fecha) {
        this.fecha = fecha;
    }

    public byte getNoches() {
        return noches;
    }

    public void setNoches(byte noches) {
        this.noches = noches;
    }

    public byte getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(byte huespedes) {
        this.huespedes = huespedes;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public byte getPago() {
        return pago;
    }

    public void setPago(byte pago) {
        this.pago = pago;
    }

    public Huesped getOwnedByHuesped() {
        return ownedByHuesped;
    }

    public void setOwnedByHuesped(Huesped ownedByHuesped) {
        this.ownedByHuesped = ownedByHuesped;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", fecha='" + fecha + '\'' +
                ", noches=" + noches +
                ", huespedes=" + huespedes +
                ", estado=" + estado +
                ", pago=" + pago +
                '}';
    }

    public static String identificarCapicua(int codigo){
        String mensaje=null;
        int ultiDigit=0;
        int invertido=0;
        for(int i=codigo; i>0; i/=10){
            ultiDigit=i%10;
            invertido= invertido*10+ultiDigit;
        }
        if(codigo==invertido){
            mensaje=codigo+"";
        }
        return mensaje;
    }
}