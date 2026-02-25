package AbstractFactory.controller;

import AbstractFactory.model.*;

public class RestauranteFactory extends FactoryAbstract {
    
    @Override
    public Menu crearMenuSemanal(Plato entrante, Plato principal, Plato postre, Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();

        principal.setAcompanamiento(acompanamiento);

        menu.asignarPlato(entrante);
        menu.asignarPlato(principal);
        menu.asignarPlato(postre);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada(Plato primero) {
        Menu menu = new MenuTemporada();

        menu.asignarPlato(primero);

        return menu;
    }
}
