package AbstractFactory.model;

public class MenuTemporada extends Menu {

    @Override
    public float calcularPrecio() {
        float total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        return total;
    }
}
