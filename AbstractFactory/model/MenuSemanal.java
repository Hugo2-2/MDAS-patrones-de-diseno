package AbstractFactory.model;

public class MenuSemanal extends Menu {

    @Override
    public void asignarPlato(Plato plato) {
        if(platos.size() < 3){
            platos.add(plato);
        }
    }
    
}
