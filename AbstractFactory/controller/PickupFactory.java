package AbstractFactory.controller;

import AbstractFactory.model.*;
import Bloque1.AbstractFactory.controller.FactoryAbstract;


public class PickupFactory extends FactoryAbstract {

    @Override
    public Menu crearMenuSemanal(Plato entrante, Plato principal, Plato postre,  Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();

        entrante.setPrecio(entrante.getPrecio() * 1.02f);
        principal.setPrecio(principal.getPrecio() * 1.02f);
        principal.setAcompanamiento(acompanamiento);

        menu.asignarPlato(entrante);
        menu.asignarPlato(principal);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada(Plato primero) {
        Menu menu = new MenuTemporada();

        
        primero.setPrecio(primero.getPrecio() * 1.02f);

        menu.asignarPlato(primero);

        return menu;
    }
    
}
