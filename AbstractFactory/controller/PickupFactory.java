package AbstractFactory.controller;

import AbstractFactory.model.*;


public class PickupFactory extends FactoryAbstract {

    @Override
    public Menu crearMenuSemanal() {
        Menu menu = new MenuSemanal();

        Plato primero = new Plato("Primero para llevar", TipoPlato.PRIMERO, Acompanamiento.ENSALADA);
        primero.asignarPrecio(8.0f * INCREMENTO);

        Plato segundo = new Plato("Segundo para llevar", TipoPlato.SEGUNDO, Acompanamiento.PATATAS);
        segundo.asignarPrecio(10.0f * INCREMENTO);

        menu.asignarPlato(primero);
        menu.asignarPlato(segundo);

        return menu;
    }

    @Override
    public Menu crearMenuTemporada() {
        Menu menu = new MenuTemporada();

        Plato primero = new Plato("Plato temporada para llevar", TipoPlato.PRIMERO, Acompanamiento.VERDURAS);
        primero.asignarPrecio(12.0f * INCREMENTO);

        menu.asignarPlato(primero);

        return menu;
    }
    
}
