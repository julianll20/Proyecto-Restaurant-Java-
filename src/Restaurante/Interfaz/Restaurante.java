package src.Restaurante.Interfaz;
// Aqui administro todos los métodos a utilizar en el restaurante
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import src.Restaurante.Clases.Camarero;
import src.Restaurante.Clases.Cliente;
import src.Restaurante.Clases.Cocinero;
import src.Restaurante.Clases.Empleado;
import src.Restaurante.Clases.Mesa;
import src.Restaurante.Clases.Reserva;
 // Atributos del restaurante
public class Restaurante {
    private String nombre;
    private String direccion;
    private ArrayList<Mesa> mesas;
    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;

    // Atributo estático para llevar la cuenta del número total de mesas
    private static int totalMesas = 0;
  // Constructor del restaurante
    public Restaurante(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    // Métodos getter y setter para los atributos del restaurante
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
     // Método para agregar una mesa al restaurante
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
        totalMesas++;
    }
// Método para agregar una reserva al restaurante
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
// Método para agregar un cliente al restaurante
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
  // Método para agregar un empleado al restaurante
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarDisponibilidadMesas() {
        System.out.println("Disponibilidad de mesas:");
        for (Mesa mesa : mesas) {
            if (mesa.getReserva() == null) {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Disponible");
            } else {
                System.out.println("Mesa " + mesa.getNumMesa() + ": Ocupada");
            }
        }
    }
// Metodo para mostrar el historial de reservas
    public void mostrarHistorialReservas() {
        System.out.println("Historial de reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNombre() + ", Fecha: " + reserva.getFecha() + ", Hora: " + reserva.getHora());
        }
    }
// Cancelacion de la reserva
    public void cancelarReserva(String nombreClienteCancelar) {
        boolean reservaEncontradaCancelar = false;
        for (Iterator<Reserva> iterator = reservas.iterator(); iterator.hasNext();) {
            Reserva reserva = iterator.next();
            if (reserva.getCliente().getNombre().equalsIgnoreCase(nombreClienteCancelar)) {
                reservaEncontradaCancelar = true;
                iterator.remove();
                for (Mesa mesa : mesas) {
                    if (mesa.getReserva() == reserva) {
                        mesa.setReserva(null);
                        break;
                    }
                }
                System.out.println("Reserva cancelada con éxito para " + nombreClienteCancelar);
                break;
            }
        }
        if (!reservaEncontradaCancelar) {
            System.out.println("No se encontró ninguna reserva para el cliente proporcionado.");
        }
    }

    // Método estático para obtener el número total de mesas
    public static int getTotalMesas() {
        return totalMesas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Mi Restaurante", "Dirección del Restaurante");

        // Agregar nuevas mesas
        restaurante.agregarMesa(new Mesa(1, 10));
        restaurante.agregarMesa(new Mesa(2, 10));
        restaurante.agregarMesa(new Mesa(3, 10));
        restaurante.agregarMesa(new Mesa(4, 10));
        restaurante.agregarMesa(new Mesa(5, 10));

        // Contratar empleados
        restaurante.agregarEmpleado(new Camarero("Juan"));
        restaurante.agregarEmpleado(new Cocinero("María"));

        while (true) {
            System.out.println("Bienvenido al sistema de gestión de reservas del restaurante.");
            System.out.println("Por favor, seleccione una opción:");
            System.out.println("1. Realizar una reserva");
            System.out.println("2. Cancelar una reserva");
            System.out.println("3. Modificar una reserva");
            System.out.println("4. Asignar mesa a cliente sin reserva");
            System.out.println("5. Mostrar disponibilidad de mesas");
            System.out.println("6. Mostrar historial de reservas");
            System.out.println("7. Mostrar el número total de mesas");
            System.out.println("8. Salir");
//MANEJO DE EXCEPCIONES CON try-catch
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                    //Realizar reserva
                        realizarReserva(scanner, restaurante);
                        break;
                    case 2:
                    //Cancelar reserva
                        cancelarReserva(scanner, restaurante);
                        break;
                    case 3:
                    //Modificar reserva
                        modificarReserva(scanner, restaurante);
                        break;
                    case 4:
                    //Asignar mesas
                        asignarMesaSinReserva(scanner, restaurante);
                        break;
                    case 5:
                    //Mostras disponibilidad en el restaurante
                        restaurante.mostrarDisponibilidadMesas();
                        break;
                    case 6:
                    //Mostras historial de las reservas hechas
                        restaurante.mostrarHistorialReservas();
                        break;
                    case 7:
                        System.out.println("Numero total de mesas en el restaurante: " + Restaurante.getTotalMesas());
                        break;
                    case 8:
                        System.out.println("¡Gracias por utilizar nuestro sistema!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
//MAENJO DE EXCEPCIONES
    private static void realizarReserva(Scanner scanner, Restaurante restaurante) {
        try {
            String nombreCliente;
            while (true) {
                System.out.println("Ingrese su nombre:");
                nombreCliente = scanner.nextLine();

                if (nombreCliente.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese solo letras.");
                }
            }

            String telefonoCliente;
            while (true) {
                System.out.println("Ingrese su número de teléfono:");
                telefonoCliente = scanner.nextLine();

                if (telefonoCliente.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese solo números.");
                }
            }

            String correoCliente;
            while (true) {
                System.out.println("Ingrese correo electronico:");
                correoCliente = scanner.nextLine();

                if (correoCliente.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese un correo electronico valido.");
                }
            }

            Cliente cliente = new Cliente(nombreCliente, telefonoCliente, correoCliente);
            restaurante.agregarCliente(cliente);

            System.out.println("Seleccione una mesa:");
            restaurante.mostrarDisponibilidadMesas();
            int numMesa = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese la fecha de la reserva (dd/mm/aaaa):");
            String fechaReserva = scanner.nextLine();
            System.out.println("Ingrese la hora de la reserva (hh:mm):");
            String horaReserva = scanner.nextLine();
            System.out.println("Ingrese el número de personas:");
            int numPersonas = scanner.nextInt();
            scanner.nextLine();

            Mesa mesaSeleccionada = null;
            for (Mesa mesa : restaurante.getMesas()) {
                if (mesa.getNumMesa() == numMesa && mesa.getReserva() == null) {
                    mesaSeleccionada = mesa;
                    break;
                }
            }

            if (mesaSeleccionada != null) {
                Reserva reserva = new Reserva(fechaReserva, horaReserva, numPersonas, cliente);
                mesaSeleccionada.setReserva(reserva);
                restaurante.agregarReserva(reserva);
                System.out.println("¡Reserva realizada con éxito!");
                System.out.println("Gracias por utilizar nuestro sistema");
                //cierre del programa si se cumple la condicion 
            } else {
                System.out.println("La mesa seleccionada no está disponible.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la reserva: " + e.getMessage());
        }
    }
//CANCELACION DE RESERVA
    private static void cancelarReserva(Scanner scanner, Restaurante restaurante) {
        try {
            System.out.println("Ingrese el nombre del cliente para cancelar la reserva:");
            String nombreClienteCancelar = scanner.nextLine();
            restaurante.cancelarReserva(nombreClienteCancelar);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al cancelar la reserva: " + e.getMessage());
        }
    }
//Modificar las reservas 
    private static void modificarReserva(Scanner scanner, Restaurante restaurante) {
        try {
            System.out.println("Ingrese el nombre del cliente para modificar la reserva:");
            String nombreClienteModificar = scanner.nextLine();

            boolean reservaEncontradaModificar = false;
            for (Reserva reserva : restaurante.getReservas()) {
                if (reserva.getCliente().getNombre().equalsIgnoreCase(nombreClienteModificar)) {
                    reservaEncontradaModificar = true;

                    System.out.println("Ingrese la nueva fecha de la reserva (dd/mm/aaaa):");
                    String nuevaFecha = scanner.nextLine();
                    System.out.println("Ingrese la nueva hora de la reserva (hh:mm):");
                    String nuevaHora = scanner.nextLine();
                    System.out.println("Ingrese el nuevo número de personas:");
                    int nuevoNumPersonas = scanner.nextInt();
                    scanner.nextLine();

                    reserva.setFecha(nuevaFecha);
                    reserva.setHora(nuevaHora);
                    reserva.setNumPersonas(nuevoNumPersonas);

                    System.out.println("¡Reserva modificada con éxito!");
                    System.out.println("Gracias por utilizar nuestro sistema");
                    break;//cierre del programa si se cumple la condicion 
                }
            }
            if (!reservaEncontradaModificar) {
                System.out.println("No se encontró ninguna reserva para el cliente proporcionado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar la reserva: " + e.getMessage());
        }
    }
//Metodo para asignar mesas a clientes sin una reservacion previa
    private static void asignarMesaSinReserva(Scanner scanner, Restaurante restaurante) {
        try {
            String nombreCliente;
            while (true) {
                System.out.println("Ingrese su nombre:");
                nombreCliente = scanner.nextLine();

                if (nombreCliente.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese solo letras.");
                }
            }

            String telefonoCliente;
            while (true) {
                System.out.println("Ingrese su número de teléfono:");
                telefonoCliente = scanner.nextLine();

                if (telefonoCliente.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese solo números.");
                }
            }

            String correoCliente;
            while (true) {
                System.out.println("Ingrese correo electronico:");
                correoCliente = scanner.nextLine();

                if (correoCliente.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese un correo electronico valido.");
                }
            }

            Cliente cliente = new Cliente(nombreCliente, telefonoCliente, correoCliente);
            restaurante.agregarCliente(cliente);

            System.out.println("Seleccione una mesa:");
            restaurante.mostrarDisponibilidadMesas();
            int numMesa = scanner.nextInt();
            scanner.nextLine();

            Mesa mesaSeleccionada = null;
            for (Mesa mesa : restaurante.getMesas()) {
                if (mesa.getNumMesa() == numMesa && mesa.getReserva() == null) {
                    mesaSeleccionada = mesa;
                    break;
                }
            }

            if (mesaSeleccionada != null) {
                Reserva reserva = new Reserva("Sin fecha", "Sin hora", 0, cliente);
                mesaSeleccionada.setReserva(reserva);
                restaurante.agregarReserva(reserva);
                System.out.println("¡Mesa asignada con éxito!");
                System.out.println("Gracias por utilizar nuestro sistema");
                //cierre del programa si se cumple la condicion 
            } else {
                System.out.println("La mesa seleccionada no está disponible.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Ocurrió un error al asignar la mesa: " + e.getMessage());
        }
    }
}
