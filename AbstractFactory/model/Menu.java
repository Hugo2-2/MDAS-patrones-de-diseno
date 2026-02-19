package AbstractFactory.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    protected List<Plato> platos = new ArrayList<>();
    
    public abstract float calcularPrecio();

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(Plato plato) {
        if(platos.size() < 3){
            platos.add(plato);
        }
    }
}
