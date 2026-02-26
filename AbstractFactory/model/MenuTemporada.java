package AbstractFactory.model;

public class MenuTemporada extends Menu {

    @Override
    public void asignarPlato(Plato plato) {
        if(platos.isEmpty()){
            platos.add(plato);
        }
    }
}
