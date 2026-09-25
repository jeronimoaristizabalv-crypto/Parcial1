package co.edu.uniquindio.poo.model;

/**represetna el hotel
 * @version 1.0
 * @author Esteban Vega Sanchez y Jeronimo Aristizabal Vanegas
 * @fecha: 24/09/2026
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel{

    private String nombre;
    private String NIT;
    private String direccion;
    private String telefono;

    private ArrayList<Huesped> listaHuespedes;
    private  Habitacion[] listaHabitaciones;

    public Hotel(String nombre, String NIT,String direccion, String telefono){

        this.nombre = nombre;
        this.NIT=NIT;
        this.direccion=direccion;
        this.telefono=telefono;

        listaHuespedes=new ArrayList<>();
        listaHabitaciones=new Habitacion[10];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public Habitacion[] getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(Habitacion[] listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", NIT='" + NIT + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaHuespedes=" + listaHuespedes +
                ", listaHabitaciones=" + Arrays.toString(listaHabitaciones) +
                '}';
    }

    public String agregarHuesped(String identificacion, String nombre, byte edad, String telefono, String ciudad){
        String mensaje ="";

        Huesped buscado= obtenerHuesped(identificacion);

        if(buscado!= null){
            return "Este huesped ya se encuentra registrado.";
        }else{
            Huesped huespedNuevo = new Huesped(identificacion, nombre, edad, telefono, ciudad, this);
            listaHuespedes.add(huespedNuevo);
            mensaje ="Huesped registrado con exito.";
        }
        return mensaje;
    }

    public Huesped obtenerHuesped(String identificacion){
        Huesped encontrarHuesped = null;

        for(Huesped ayuda: listaHuespedes){
            if(ayuda.getIdentificacion().equals(identificacion)){
                return ayuda;
            }
        }
        return encontrarHuesped;
    }

    // Función recién agregada
    public char[][] crearMatrizOcupacion(){
        char[][] matriz = new char[10][7];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = 'D';
            }
        }

        for(Huesped huesped : listaHuespedes){
            for(Reserva reserva : huesped.getListaReservas()){
                int fila = encontrarPosicionHabitacion(reserva.getNumeroHabitacion());
                if(fila != -1){
                    for(int i = 0; i < reserva.getNoches(); i++){
                        int columna = reserva.getFecha() - 1 + i;
                        if(columna < 7){
                            matriz[fila][columna] = 'O';
                        }
                    }
                }
            }
        }
        return matriz;
    }

    public Habitacion encontrarHabitacion(int numero){
        Habitacion habitacionNoEncontrada=null;
        for(Habitacion ayuda:listaHabitaciones){
            if(ayuda.getNumero()==numero){
                return ayuda;
            }
        }
        return habitacionNoEncontrada;
    }

    public String mostrarDatosHuesped(String numero){
        String mensaje = "";
        for(Huesped ayuda: listaHuespedes){
            if(ayuda.getTelefono().equals(numero)){
                mensaje="El nombre del huesped es: "+ayuda.getNombre()+
                        "\nSu identificacion es: "+ayuda.getIdentificacion()+
                        "\nSu ciudad es: "+ayuda.getCiudad()+
                        "\nSus reservas son: "+ayuda.getListaReservas();
            }
        }
        return mensaje;
    }

    public int encontrarPosicionHabitacion(int numero){
        int habitacionNoEncontrada = -1;
        for(int i = 0;i<listaHabitaciones.length;i++){
            if(listaHabitaciones[i].getNumero()==numero){
                return i;
            }
        }
        return habitacionNoEncontrada;
    }

    public double calcularTotal(Reserva reserva, int numero){
        double total =0;
        for(int i = 0;i<listaHabitaciones.length;i++){
            if(listaHabitaciones[i].getNumero()==numero){
                total= reserva.getNoches()*listaHabitaciones[i].getPrecio();
            }
        }
        return total;
    }

    public Huesped encontrarHuespedTelefono(String numero){
        Huesped noEncontrado=null;

        for(Huesped ayuda: listaHuespedes){
            if(ayuda.getTelefono().equals(numero)){
                return ayuda;
            }
        }
        return noEncontrado;
    }

    public double calcularIngresosPorFecha(byte fecha){
        double ingresos = 0;

        for(Huesped huesped : listaHuespedes){
            for(Reserva reserva : huesped.getListaReservas()){
                if(reserva.getFecha() == fecha){
                    ingresos += reserva.getTotal();
                }
            }
        }
        return ingresos;
    }

    public void mostrarMatrizOcupacion(char[][] cambiarMatrizOcupacion){
        for(char[] filas:cambiarMatrizOcupacion){
            for(char letras:filas){
                System.out.print("[" + letras + "]");
            }
            System.out.println("");
        }
    }

    public int diaMayorOcupacion(char[][] matriz){
        int mayor=-1;
        int dia = 0;

        for(int i = 0; i< matriz[0].length;i++){
            int contador=0;
            for(int e = 0; e< matriz.length;e++){
                if(matriz[e][i]=='O'){
                    contador++;
                }
            }
            if(contador>mayor){
                mayor=contador;
                dia=i+1;
            }
        }
        return dia;
    }

    public int diaMenorOcupacion(char[][] matriz){
        int masDisponibles=0;
        int dia = 0;

        for(int i = 0; i< matriz[0].length;i++){
            int contador=0;
            for(int e = 0; e< matriz.length;e++){
                if(matriz[e][i]=='D'){
                    contador++;
                }
            }
            if(contador>masDisponibles){
                masDisponibles=contador;
                dia=i+1;
            }
        }
        return dia;
    }

    public int totalHabitacionesOcupadas(char[][] matriz){
        int contador=0;

        for(int i = 0; i< matriz[0].length;i++){
            for(int e = 0; e< matriz.length;e++){
                if(matriz[e][i]=='O'){
                    contador++;
                }
            }
        }
        return contador;
    }

    public int contarHabitacionesPorEstado(int estado){
        int contador = 0;

        for(Habitacion habitacion : listaHabitaciones){
            if(habitacion.getEstado() == estado){
                contador++;
            }
        }
        return contador;
    }

    public Habitacion obtenerHabitacionMayorPrecio(){
        Habitacion mayor = listaHabitaciones[0];

        for(Habitacion habitacion : listaHabitaciones){
            if(habitacion.getPrecio() > mayor.getPrecio()){
                mayor = habitacion;
            }
        }
        return mayor;
    }

    public Habitacion obtenerHabitacionMenorPrecio(){
        Habitacion menor = listaHabitaciones[0];

        for(Habitacion habitacion : listaHabitaciones){
            if(habitacion.getPrecio() < menor.getPrecio()){
                menor = habitacion;
            }
        }
        return menor;
    }

}