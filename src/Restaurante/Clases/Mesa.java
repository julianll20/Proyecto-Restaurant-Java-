package src.Restaurante.Clases;

public class Mesa {
    private int numMesa;
    private int capacidadmax;
    private String estado;
    private Reserva reserva;

    public Mesa(int numMesa, int capacidadmax) {
        this.numMesa = numMesa;
        this.capacidadmax = capacidadmax;
        this.estado = "Disponible";
        this.reserva = null;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCapacidadmax() {
        return capacidadmax;
    }

    public void setCapacidad(int capacidadmax) {
        this.capacidadmax = capacidadmax;
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
