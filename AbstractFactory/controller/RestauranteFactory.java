package AbstractFactory.controller;

import AbstractFactory.model.*;

public class RestauranteFactory extends FactoryAbstract {
    
    @Override
    public Menu crearMenuSemanal(Acompanamiento acompanamiento) {
        Menu menu = new MenuSemanal();

        Plato entrante = new Plato("Ensalada César", TipoPlato.ENTRANTE, 5.0f);
        Plato principal = new Plato("Entrecot", TipoPlato.PRINCIPAL, 15.0f);
        Plato postre = new Plato("Tarta de Queso", TipoPlato.POSTRE, 4.0f);

        principal.setAcompanamiento(acompanamiento);

        menu.asignarPlato(entrante);
        menu.asignarPlato(principal);
        menu.asignarPlato(postre);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();

        Plato temporada = new Plato("Guiso especial de invierno", TipoPlato.PRINCIPAL, 12.0f);

        menu.asignarPlato(temporada);

        return menu;
    }
}
