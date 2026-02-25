package AbstractFactory.model;

public class Plato {
    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private Acompanamiento acompanamiento;

    public Plato(String nombre, TipoPlato tipo, float precio, Acompanamiento acompanamiento) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.acompanamiento = acompanamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public Acompanamiento getAcompanamiento() {
        return acompanamiento;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                ", acompanamiento=" + acompanamiento +
                '}';
    }
}
