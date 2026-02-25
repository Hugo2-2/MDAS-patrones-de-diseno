package AbstractFactory.controller;

import AbstractFactory.model.Menu;
import AbstractFactory.model.Plato;

public abstract class FactoryAbstract {
    public abstract Menu crearMenuSemanal(Plato entrante, Plato principal, Plato postre, Acompanamiento acompanamiento);
    public abstract Menu crearMenuTemporada(Plato primero);
}
