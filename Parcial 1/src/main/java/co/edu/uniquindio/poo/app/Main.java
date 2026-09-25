package co.edu.uniquindio.poo.app;

/**
 * Esta clase pertenece al Main del programa
 * @version 1.0
 * @author Esteban Vega Sanchez y Jeronimo Aristizabal Vanegas
 * @fecha: 24/09/2026
 */

import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Reserva;

import javax.swing.*;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){


        JOptionPane.showMessageDialog(null,"Bienvenido al sistema de gestion del hotel.");
        String nombre = JOptionPane.showInputDialog(null,"Ingresa el nombre del hotel: ");
        String NIT = JOptionPane.showInputDialog(null,"Ingresa el NIT del hotel: ");
        String direccion = JOptionPane.showInputDialog(null,"Ingresa la direccion del hotel: ");
        String telefono = JOptionPane.showInputDialog(null,"Ingresa el telefono del hotel: ");

        Hotel hotel = new Hotel(nombre,NIT,direccion,telefono);
        JOptionPane.showMessageDialog(null,"En el hotel "+nombre+" contamos con 10 habitaciones"+
                "\nlas cuales van del numero 101 al 502, las habitaciones"+
                "\ndel nivel 5 son las Suits, las del nivel 4 al 3 son "+
                "\ndobles y las del nivel 1 y 2 son individuales. ");
        Habitacion habitacion1 = new Habitacion((byte) 1, 101, (byte)1, (byte)1, 85000, (byte)2);
        Habitacion habitacion2 = new Habitacion((byte) 1, 102, (byte)1, (byte)1, 85000, (byte)2);
        Habitacion habitacion3 = new Habitacion((byte) 1, 201, (byte)1, (byte)2, 85000, (byte)2);
        Habitacion habitacion4 = new Habitacion((byte) 1, 202, (byte)1, (byte)2, 85000, (byte)2);
        Habitacion habitacion5 = new Habitacion((byte) 1, 301, (byte)2, (byte)3, 160000, (byte)4);
        Habitacion habitacion6 = new Habitacion((byte) 1, 302, (byte)2, (byte)3, 160000, (byte)4);
        Habitacion habitacion7 = new Habitacion((byte) 1, 401, (byte)2, (byte)4, 160000, (byte)4);
        Habitacion habitacion8 = new Habitacion((byte) 1, 402, (byte)2, (byte)4, 160000, (byte)4);
        Habitacion habitacion9 = new Habitacion((byte) 1, 501, (byte)3, (byte)5, 320000, (byte)8);
        Habitacion habitacion10 = new Habitacion((byte) 1, 502, (byte)3, (byte)5, 320000, (byte)8);

        hotel.getListaHabitaciones()[0]=habitacion1;
        hotel.getListaHabitaciones()[1]=habitacion2;
        hotel.getListaHabitaciones()[2]=habitacion3;
        hotel.getListaHabitaciones()[3]=habitacion4;
        hotel.getListaHabitaciones()[4]=habitacion5;
        hotel.getListaHabitaciones()[5]=habitacion6;
        hotel.getListaHabitaciones()[6]=habitacion7;
        hotel.getListaHabitaciones()[7]=habitacion8;
        hotel.getListaHabitaciones()[8]=habitacion9;
        hotel.getListaHabitaciones()[9]=habitacion10;

        Habitacion[] listaHabitaciones=hotel.getListaHabitaciones();

        int opcion;

        do{
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,"Seleccione una opcion: ---Menu---\n"+
                    "1. Agregar un huesped."+
                    "\n2. Agregar reserva."+
                    "\n3. Consultar huesped."+
                    "\n4. Mostrar matriz ocupacion."+
                    "\n5. Obtener las reservas que corresponde a un número especial"+
                    "\n6. Obtener los ingresos del hotel para un fecha dada"+
                    "\n7. Consultar disponibilidad de habitaciones."+
                    "\n8. Salir."));


            switch (opcion){

                case 1: crearHuesped(hotel);
                    break;

                case 2: String identificacion = JOptionPane.showInputDialog(null,"Ingresa la identificacion del huesped para reservar: ");
                    Huesped huesped = hotel.obtenerHuesped(identificacion);
                    if(huesped==null){
                        JOptionPane.showMessageDialog(null,"El huesped no existe.");
                        break;
                    }
                    crearReserva(huesped, hotel, listaHabitaciones);
                    break;

                case 3: String numero = JOptionPane.showInputDialog(null,"Ingresa el numero de telefono del huesped a consultar: ");
                    Huesped huesped2 = hotel.encontrarHuespedTelefono(numero);
                    if(huesped2==null){
                        JOptionPane.showMessageDialog(null,"El huesped no existe.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,hotel.mostrarDatosHuesped(numero));
                    break;
                case 4:
                    char[][] matriz = hotel.crearMatrizOcupacion();
                    hotel.mostrarMatrizOcupacion(matriz);

                    int diaMasOcupado = hotel.diaMayorOcupacion(matriz);
                    JOptionPane.showMessageDialog(null,"El dia en el que mas hay habitaciones ocupadas es en el dia "+diaMasOcupado);

                    int diaMasDisponible = hotel.diaMenorOcupacion(matriz);
                    JOptionPane.showMessageDialog(null,"El dia en el que mas hay habitaciones disponibles es en el dia "+diaMasDisponible);

                    int totalHabitacionesOcupadas = hotel.totalHabitacionesOcupadas(matriz);
                    JOptionPane.showMessageDialog(null,"El total de habitaciones ocupadas es "+totalHabitacionesOcupadas);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, obtenerReservasEspeciales(hotel));
                    break;

                case 6:
                    byte fecha = Byte.valueOf(JOptionPane.showInputDialog(null,
                            "Ingresa la fecha a consultar (1 lunes ... 7 domingo): "));
                    JOptionPane.showMessageDialog(null, obtenerIngresosHotel(hotel, fecha));
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null, obtenerDisponibilidadHabitaciones(hotel));
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion no valida, intenta de nuevo");
            }
        }while(opcion!=8);
    }
    public static void crearHuesped(Hotel hotel) {

        String identificacion = JOptionPane.showInputDialog(null, "Ingresa el numero de identificacion del huesped: ");
        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del huesped: ");
        byte edad = Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa la edad del huesped: "));
        String telefono = JOptionPane.showInputDialog(null, "Ingresa el telefono del huesped: ");
        String ciudad = JOptionPane.showInputDialog(null, "Ingresa la ciudad del huesped: ");

        String resultado = hotel.agregarHuesped(identificacion,nombre,edad,telefono,ciudad);
        JOptionPane.showMessageDialog(null,resultado);
        Huesped huesped = hotel.obtenerHuesped(identificacion);
    }
    public static void crearReserva(Huesped huesped, Hotel hotel, Habitacion[] listaHabitaciones) {

        int reservas = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresa la cantidad de reservas que deas realizar: "));
        for (int i = reservas; i > 0; i--) {
            Reserva datosReserva = new Reserva(Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresa el codigo de la reserva (este debe ser de 4 digitos): ")),
                    Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa la fecha (del 1 al 7, 1 siendo lunes y 7 domingo): ")),
                    Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa la cantidad de noches: ")),
                    Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa la cantidad de huespedes: ")),
                    Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa el estado de la reserva (1. Pendiente, 2. Confirmada, 3. Finalizada): ")),
                    Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa la forma de pago (1. Efectivo, 2. Tarjeta, 3. Transferencia): ")),
                    huesped);

            byte piso = Byte.valueOf(JOptionPane.showInputDialog(null, "Ingresa el piso donde te quieres hospedar (Recuerda que del piso 1 al 2 es" +
                    "\npara dos, del piso 3 al 4 es para cuatro y el piso 5 es para 8): "));
            int numero = Integer.valueOf(JOptionPane.showInputDialog(null, "Ingresa el numero de la habitacion que deseas:"));
            Habitacion habitacion = hotel.encontrarHabitacion(numero);

            if (habitacion == null) {
                JOptionPane.showMessageDialog(null, "La habitacion ingresada no existe.");
            } else if (habitacion.getPiso() != piso) {
                JOptionPane.showMessageDialog(null, "La habitacion ingresada y el piso ingresado no coinciden.");
            } else {
                datosReserva.setNumeroHabitacion(numero);
                huesped.agregarReserva(datosReserva);
                double total = hotel.calcularTotal(datosReserva, numero);
                datosReserva.setTotal(total);
                JOptionPane.showMessageDialog(null, "El total a pagar es: " + total);
            }
        }
    }

    //4. Número especial de reserva
    public static String obtenerReservasEspeciales(Hotel hotel){
        String mensaje = "Las reservas con un codigo especial son las siguientes:\n";

        for(Huesped huesped : hotel.getListaHuespedes()){
            for(Reserva reserva : huesped.getListaReservas()){
                String especial = Reserva.identificarCapicua(reserva.getCodigo());
                if(especial != null){
                    mensaje += especial + "\n";
                }
            }
        }
        return mensaje;
    }

    //5. Ingresos al hotel
    public static String obtenerIngresosHotel(Hotel hotel, byte fecha){
        double ingresos = hotel.calcularIngresosPorFecha(fecha);
        return "El ingreso total del dia " + fecha + " fue: " + ingresos;
    }

    public static String obtenerDisponibilidadHabitaciones(Hotel hotel){
        Habitacion mayor = hotel.obtenerHabitacionMayorPrecio();
        Habitacion menor = hotel.obtenerHabitacionMenorPrecio();

        String mensaje = "Disponibilidad de habitaciones:\n";
        mensaje += "Disponibles: " + hotel.contarHabitacionesPorEstado(1) + "\n";
        mensaje += "Ocupadas: " + hotel.contarHabitacionesPorEstado(2) + "\n";
        mensaje += "En mantenimiento: " + hotel.contarHabitacionesPorEstado(2) + "\n\n";
        mensaje += "Habitacion con mayor precio por noche: " + mayor.getNumero() + " ($" + mayor.getPrecio() + ")\n";
        mensaje += "Habitacion con menor precio por noche: " + menor.getNumero() + " ($" + menor.getPrecio() + ")";

        return mensaje;
    }
}
