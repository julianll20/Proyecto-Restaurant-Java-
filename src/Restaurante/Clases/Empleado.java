package src.Restaurante.Clases;

public abstract class Empleado { //Clase abstracta es empleado
    private String nombre;
    private String puesto;
    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
// Con el metodo trabajar aplicamos polimorfismo sin saber que empleado es
    public abstract void trabajar();
}
