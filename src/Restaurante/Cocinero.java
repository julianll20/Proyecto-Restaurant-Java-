package src.Restaurante;

public class Cocinero extends Empleado {
    public Cocinero(String nombre) {
        super(nombre, "Cocinero");
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está cocinando.");
    }
}
