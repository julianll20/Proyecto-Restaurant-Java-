//Aqui administro todos los metodos a utiliza ren el restaurante
package src.Restaurante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Restaurante {
    private String nombre;
    private String direccion;
    private ArrayList<Mesa> mesas;
    private ArrayList<Reserva> reservas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Empleado> empleados;

    // Atributo estático para llevar la cuenta del número total de mesas
    private static int totalMesas = 0;

    public Restaurante(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.mesas = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

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

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
        totalMesas++;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

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

    public void mostrarHistorialReservas() {
        System.out.println("Historial de reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNombre() + ", Fecha: " + reserva.getFecha() + ", Hora: " + reserva.getHora());
        }
    }

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
        restaurante.agregarMesa(new Mesa(1, 4));
        restaurante.agregarMesa(new Mesa(2, 6));
        restaurante.agregarMesa(new Mesa(3, 4));
        restaurante.agregarMesa(new Mesa(4, 6));
        restaurante.agregarMesa(new Mesa(5, 4));

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
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Realizar una reserva
                    System.out.println("Ingrese su nombre:");
                    String nombreCliente = scanner.nextLine();
                    System.out.println("Ingrese su número de teléfono:");
                    String telefonoCliente = scanner.nextLine();
                    System.out.println("Ingrese su correo electrónico:");
                    String correoCliente = scanner.nextLine();
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
                    } else {
                        System.out.println("La mesa seleccionada no está disponible.");
                    }
                    break;
                case 2:
                    // Cancelar una reservación
                    System.out.println("Ingrese el nombre del cliente para cancelar la reserva:");
                    String nombreClienteCancelar = scanner.nextLine();
                    restaurante.cancelarReserva(nombreClienteCancelar);
                    break;
                case 3:
                    // Modificar una reservación
                    System.out.println("Ingrese el nombre del cliente para modificar la reserva:");
                    String nombreClienteModificar = scanner.nextLine();
                    boolean reservaEncontrada = false;
                    for (Reserva reserva : restaurante.getReservas()) {
                        if (reserva.getCliente().getNombre().equalsIgnoreCase(nombreClienteModificar)) {
                            reservaEncontrada = true;
                            System.out.println("Reserva encontrada:");
                            System.out.println("Fecha: " + reserva.getFecha());
                            System.out.println("Hora: " + reserva.getHora());
                            System.out.println("Número de personas: " + reserva.getNumPersonas());
                            System.out.println("¿Qué desea modificar?");
                            System.out.println("1. Fecha");
                            System.out.println("2. Hora");
                            System.out.println("3. Número de personas");
                            int opcionModificar = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcionModificar) {
                                case 1:
                                    System.out.println("Ingrese la nueva fecha (dd/mm/aaaa):");
                                    String nuevaFecha = scanner.nextLine();
                                    reserva.setFecha(nuevaFecha);
                                    System.out.println("¡Fecha de reserva modificada con éxito!");
                                    break;
                                case 2:
                                    System.out.println("Ingrese la nueva hora (hh:mm):");
                                    String nuevaHora = scanner.nextLine();
                                    reserva.setHora(nuevaHora);
                                    System.out.println("¡Hora de reserva modificada con éxito!");
                                    break;
                                case 3:
                                    System.out.println("Ingrese el nuevo número de personas:");
                                    int nuevoNumPersonas = scanner.nextInt();
                                    scanner.nextLine();
                                    reserva.setNumPersonas(nuevoNumPersonas);
                                    System.out.println("¡Número de personas de reserva modificado con éxito!");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                                    break;
                            }
                            break;
                        }
                    }
                    if (!reservaEncontrada) {
                        System.out.println("No se encontró ninguna reserva para el cliente proporcionado.");
                    }
                    break;
                case 4:
                    // Asignar mesa a cliente sin reserva
                    System.out.println("Ingrese su nombre:");
                    String nombreClienteSinReserva = scanner.nextLine();
                    Cliente clienteSinReserva = null;
                    for (Cliente clienteTemp : restaurante.getClientes()) {
                        if (clienteTemp.getNombre().equalsIgnoreCase(nombreClienteSinReserva)) {
                            clienteSinReserva = clienteTemp;
                            break;
                        }
                    }
                    if (clienteSinReserva == null) {
                        System.out.println("Cliente no registrado. Ingrese su número de teléfono:");
                        String telefonoClienteSinReserva = scanner.nextLine();
                        System.out.println("Ingrese su correo electrónico:");
                        String correoClienteSinReserva = scanner.nextLine();
                        clienteSinReserva = new Cliente(nombreClienteSinReserva, telefonoClienteSinReserva, correoClienteSinReserva);
                        restaurante.agregarCliente(clienteSinReserva);
                    }
                    System.out.println("Seleccione una mesa disponible:");
                    restaurante.mostrarDisponibilidadMesas();
                    int numMesaSinReserva = scanner.nextInt();
                    scanner.nextLine();
                    Mesa mesaSeleccionadaSinReserva = null;
                    for (Mesa mesa : restaurante.getMesas()) {
                        if (mesa.getNumMesa() == numMesaSinReserva && mesa.getReserva() == null) {
                            mesaSeleccionadaSinReserva = mesa;
                            break;
                        }
                    }
                    if (mesaSeleccionadaSinReserva != null) {
                        mesaSeleccionadaSinReserva.setEstado("Ocupada");
                        System.out.println("¡Mesa asignada con éxito al cliente sin reserva!");
                    } else {
                        System.out.println("La mesa seleccionada no está disponible.");
                    }
                    break;
                case 5:
                    // Mostrar mesas ocupadas
                    restaurante.mostrarDisponibilidadMesas();
                    break;
                case 6:
                    // Mostrar historial de reservas del restaurante
                    restaurante.mostrarHistorialReservas();
                    break;
                case 7:
                    // Mostrar el número total de mesas
                    System.out.println("Número total de mesas en el restaurante: " + Restaurante.getTotalMesas());
                    break;
                case 8:
                    // Salir del programa
                    System.out.println("¡Gracias por utilizar nuestro sistema!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
