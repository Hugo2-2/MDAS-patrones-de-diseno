package AbstractFactory.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Plato> platos = new ArrayList<>();

    public float calcularPrecio() {
        float total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        return total;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public abstract void asignarPlato(Plato plato);
}
