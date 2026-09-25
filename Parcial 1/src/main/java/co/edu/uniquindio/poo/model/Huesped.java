package co.edu.uniquindio.poo.model;

/**
 * Esta clase representa un huesped el hotel
 * @version 1.0
 * @author Esteban Vega Sanchez y Jeronimo Aristizabal Vanegas
 * @fecha: 24/09/2026
 */

import java.util.ArrayList;

public class Huesped {

    private String identificacion;
    private String nombre;
    private byte edad;
    private String telefono;
    private String ciudad;

    private Hotel ownedByHotel;
    private ArrayList<Reserva>listaReservas;

    public Huesped(String identificacion, String nombre, byte edad, String telefono, String ciudad, Hotel ownedByHotel){

        this.identificacion=identificacion;
        this.nombre=nombre;
        this.edad=edad;
        this.telefono=telefono;
        this.ciudad=ciudad;

        this.ownedByHotel=ownedByHotel;
        listaReservas=new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Hotel getOwnedByHotel() {
        return ownedByHotel;
    }

    public void setOwnedByHotel(Hotel ownedByHotel) {
        this.ownedByHotel = ownedByHotel;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaReservas=" + listaReservas +
                '}';
    }

    public String agregarReserva(Reserva reserva){
        String mensaje="";

        Reserva buscada = obtenerReserva(reserva.getCodigo());

        if(buscada!=null){
            return "Esta reserva ya fue registrada";
        }else{
            listaReservas.add(reserva);
            mensaje= "Reserva registrada con exito";
        }
        return mensaje;
    }

    public Reserva obtenerReserva(int codigo){
        Reserva encontrarReserva=null;

        for(Reserva ayuda: listaReservas){
            if(ayuda.getCodigo()==(codigo)){
                return ayuda;
            }
        }
        return encontrarReserva;
    }

}