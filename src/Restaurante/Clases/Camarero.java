package src.Restaurante.Clases;

public class Camarero extends Empleado {
    public Camarero(String nombre) {
        super(nombre, "Camarero");
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está sirviendo mesas.");
    }
}
