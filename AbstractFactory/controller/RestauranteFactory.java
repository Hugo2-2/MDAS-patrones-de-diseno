package AbstractFactory.controller;

import AbstractFactory.model.*;
import Bloque1.AbstractFactory.controller.FactoryAbstract;

public class RestauranteFactory extends FactoryAbstract {
    
    @Override
    public Menu crearMenuSemanal(Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();

        Plato primero = new Plato("Primero", TipoPlato.ENTRANTE, 8.0f, Acompanamiento.NINGUNO);
        

        Plato segundo = new Plato("Segundo", TipoPlato.PRINCIPAL, 10.0f, Acompanamiento.NINGUNO);
        

        Plato postre = new Plato("Postre", TipoPlato.POSTRE,  3.0f, Acompanamiento.NINGUNO);


        menu.asignarPlato(primero);
        menu.asignarPlato(segundo);
        menu.asignarPlato(postre);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada(Acompanamiento acompanamiento) {
        Menu menu = new MenuTemporada();

        Plato primero = new Plato("Primero", TipoPlato.ENTRANTE, 8.0f, Acompanamiento.NINGUNO); 
    

        Plato segundo = new Plato("Segundo", TipoPlato.PRINCIPAL, 10.0f , acompanamiento);
    

        Plato postre = new Plato("Postre", TipoPlato.POSTRE, 3.0f , Acompanamiento.NINGUNO);


        menu.asignarPlato(primero);
        menu.asignarPlato(segundo);
        menu.asignarPlato(postre);

        return menu;
    }
}
