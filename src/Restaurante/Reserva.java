package src.Restaurante;

public class Reserva {
    private String fecha;
    private String hora;
    private int numPersonas;
    private String estado;
    private Cliente cliente;

    public Reserva(String fecha, String hora, int numPersonas, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.numPersonas = numPersonas;
        this.estado = "Pendiente";
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
