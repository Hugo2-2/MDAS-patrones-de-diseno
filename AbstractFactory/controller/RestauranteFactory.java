package AbstractFactory.controller;

import AbstractFactory.model.*;

public class RestauranteFactory extends FactoryAbstract {
    
    @Override
    public Menu crearMenuSemanal() {
        Menu menu = new MenuSemanal();

        Plato primero = new Plato("Primero", TipoPlato.PRIMERO, Acompanamiento.ENSALADA);
        primero.asignarPrecio(8.0f);

        Plato segundo = new Plato("Segundo", TipoPlato.SEGUNDO, Acompanamiento.PATATAS);
        segundo.asignarPrecio(10.0f);

        Plato postre = new Plato("Postre", TipoPlato.POSTRE, Acompanamiento.NINGUNO);
        postre.asignarPrecio(3.0f);

        menu.asignarPlato(primero);
        menu.asignarPlato(segundo);
        menu.asignarPlato(postre);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();

        Plato primero = new Plato("Primero", TipoPlato.PRIMERO, Acompanamiento.ENSALADA);
        primero.asignarPrecio(8.0f);

        Plato segundo = new Plato("Segundo", TipoPlato.SEGUNDO, Acompanamiento.PATATAS);
        segundo.asignarPrecio(10.0f);

        Plato postre = new Plato("Postre", TipoPlato.POSTRE, Acompanamiento.NINGUNO);
        postre.asignarPrecio(3.0f);

        menu.asignarPlato(primero);
        menu.asignarPlato(segundo);
        menu.asignarPlato(postre);

        return menu;
    }
}
