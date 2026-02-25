package AbstractFactory.model;

public class Plato {
    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private Acompanamiento acompanamiento;

    public Plato(String nombre, TipoPlato tipo, float precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.acompanamiento = Acompanamiento.NINGUNO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }
    public Acompanamiento getAcompanamiento() {
        return acompanamiento;
    }

    public void setAcompanamiento(Acompanamiento acompanamiento) {
        this.acompanamiento = acompanamiento;
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
