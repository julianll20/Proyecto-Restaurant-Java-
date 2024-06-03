package src.Restaurante;

public class Mesa {
    private int numMesa;
    private int capacidad;
    private String estado;
    private Reserva reserva;

    public Mesa(int numMesa, int capacidad) {
        this.numMesa = numMesa;
        this.capacidad = capacidad;
        this.estado = "Disponible";
        this.reserva = null;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
