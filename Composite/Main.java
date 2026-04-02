package Composite;

import Composite.model.Consumer;
import Composite.model.Device;
import Composite.model.Space;
import java.util.ArrayList;

public class Main {

    /** Precio estimado del kWh en euros. */
    private static final double PRECIO_KWH = 0.15;

    // ---------------------------------------------------------------
    // Utilidades de impresión
    // ---------------------------------------------------------------
    private static void printConsumo(String label, Consumer consumer) {
        double kwh = consumer.calcExpenses();
        System.out.printf("  %-50s -> %8.2f kWh  |  %6.2f €%n", label, kwh, kwh * PRECIO_KWH);
    }

    private static void printSeparador(String titulo) {
        System.out.println("\n══════════════════════════════════════════════════════════════════");
        System.out.println(" " + titulo);
        System.out.println("══════════════════════════════════════════════════════════════════");
    }

    // ---------------------------------------------------------------
    // Programa principal
    // ---------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║  PATRÓN COMPOSITE – Control de Gasto Energético Universitario ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.printf("  (Precio del kWh utilizado: %.2f €)%n", PRECIO_KWH);

        // ================================================================
        //  EDIFICIO 1 – Facultad de Informática
        // ================================================================
        printSeparador("EDIFICIO 1: Facultad de Informática");

        // — Sala de servidores —
        Device servidor1      = new Device(0.50, 24.0);  // servidor rack
        Device servidor2      = new Device(0.50, 24.0);
        Device aireServidores = new Device(2.00, 24.0);  // climatización 24 h
        Device switch1        = new Device(0.05, 24.0);  // switch de red

        Space salaServidores = new Space(new ArrayList<>());
        salaServidores.addConsumer(servidor1);
        salaServidores.addConsumer(servidor2);
        salaServidores.addConsumer(aireServidores);
        salaServidores.addConsumer(switch1);

        // — Aula de prácticas (20 puestos) —
        Space aulaPracticas = buildAula(20, true);

        // — Aula teórica (proyector + iluminación) —
        Device proyectorAula  = new Device(0.30, 6.0);
        Device fluorescente1  = new Device(0.06, 8.0);
        Device fluorescente2  = new Device(0.06, 8.0);
        Device fluorescente3  = new Device(0.06, 8.0);

        Space aulaTeoria = new Space(new ArrayList<>());
        aulaTeoria.addConsumer(proyectorAula);
        aulaTeoria.addConsumer(fluorescente1);
        aulaTeoria.addConsumer(fluorescente2);
        aulaTeoria.addConsumer(fluorescente3);

        // — Aparatos fuera de salas (pasillo) —
        Device maquinaVending1   = new Device(0.40, 24.0);  // máquina de bebidas
        Device maquinaCafe1      = new Device(1.50, 4.0);   // máquina de café

        // — Edificio completo —
        Space facultadInformatica = new Space(new ArrayList<>());
        facultadInformatica.addConsumer(salaServidores);
        facultadInformatica.addConsumer(aulaPracticas);
        facultadInformatica.addConsumer(aulaTeoria);
        // Aparatos fuera de las salas (pasillos del edificio)
        facultadInformatica.addConsumer(maquinaVending1);
        facultadInformatica.addConsumer(maquinaCafe1);

        System.out.println("\n  [Dispositivos individuales – Sala de servidores]");
        printConsumo("Servidor 1",               servidor1);
        printConsumo("Servidor 2",               servidor2);
        printConsumo("Aire acondicionado",       aireServidores);
        printConsumo("Switch de red",            switch1);

        System.out.println("\n  [Salas]");
        printConsumo("Sala de servidores",       salaServidores);
        printConsumo("Aula de prácticas (20 PC)",aulaPracticas);
        printConsumo("Aula teórica",             aulaTeoria);

        System.out.println("\n  [Aparatos fuera de salas (pasillos)]");
        printConsumo("Máquina de vending",       maquinaVending1);
        printConsumo("Máquina de café",          maquinaCafe1);

        System.out.println("\n  [Total edificio]");
        printConsumo("Facultad de Informática",  facultadInformatica);

        // ================================================================
        //  EDIFICIO 2 – Biblioteca Central
        // ================================================================
        printSeparador("EDIFICIO 2: Biblioteca Central");

        // — Sala de lectura —
        Space salaLectura = new Space(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            salaLectura.addConsumer(new Device(0.06, 12.0));  // 10 lámparas de mesa
        }
        salaLectura.addConsumer(new Device(1.50, 10.0));      // climatización

        // — Sala de ordenadores (10 puestos) —
        Space salaOrdenadores = buildAula(10, false);

        // — Aparatos fuera de salas —
        Device maquinaVending2 = new Device(0.40, 24.0);
        Device impresora       = new Device(0.50, 3.0);      // impresora autoservicio

        Space biblioteca = new Space(new ArrayList<>());
        biblioteca.addConsumer(salaLectura);
        biblioteca.addConsumer(salaOrdenadores);
        biblioteca.addConsumer(maquinaVending2);
        biblioteca.addConsumer(impresora);

        System.out.println("\n  [Salas]");
        printConsumo("Sala de lectura",          salaLectura);
        printConsumo("Sala de ordenadores (10)", salaOrdenadores);

        System.out.println("\n  [Aparatos fuera de salas]");
        printConsumo("Máquina de vending",       maquinaVending2);
        printConsumo("Impresora autoservicio",   impresora);

        System.out.println("\n  [Total edificio]");
        printConsumo("Biblioteca Central",       biblioteca);

        // ================================================================
        //  EDIFICIO 3 – Aulario General
        // ================================================================
        printSeparador("EDIFICIO 3: Aulario General");

        // 4 aulas teóricas grandes
        Space aula1 = buildAulaTeoria(6, 8.0);
        Space aula2 = buildAulaTeoria(6, 8.0);
        Space aula3 = buildAulaTeoria(4, 6.0);
        Space aula4 = buildAulaTeoria(4, 6.0);

        // Aparato fuera de salas
        Device maquinaSnacks = new Device(0.35, 24.0);

        Space aulario = new Space(new ArrayList<>());
        aulario.addConsumer(aula1);
        aulario.addConsumer(aula2);
        aulario.addConsumer(aula3);
        aulario.addConsumer(aula4);
        aulario.addConsumer(maquinaSnacks);

        System.out.println("\n  [Aulas]");
        printConsumo("Aula 1 (6 fluor., 8 h)",  aula1);
        printConsumo("Aula 2 (6 fluor., 8 h)",  aula2);
        printConsumo("Aula 3 (4 fluor., 6 h)",  aula3);
        printConsumo("Aula 4 (4 fluor., 6 h)",  aula4);

        System.out.println("\n  [Aparatos fuera de salas]");
        printConsumo("Máquina de snacks",        maquinaSnacks);

        System.out.println("\n  [Total edificio]");
        printConsumo("Aulario General",          aulario);

        // ================================================================
        //  CAMPUS COMPLETO
        // ================================================================
        printSeparador("CAMPUS UNIVERSITARIO COMPLETO");

        Space campus = new Space(new ArrayList<>());
        campus.addConsumer(facultadInformatica);
        campus.addConsumer(biblioteca);
        campus.addConsumer(aulario);

        System.out.println("\n  [Resumen por edificio]");
        printConsumo("Facultad de Informática",  facultadInformatica);
        printConsumo("Biblioteca Central",       biblioteca);
        printConsumo("Aulario General",          aulario);

        System.out.println("\n  [Total campus]");
        printConsumo("CAMPUS COMPLETO",          campus);

        // ================================================================
        //  DEMOSTRACIÓN DINÁMICA: añadir / eliminar aparatos
        // ================================================================
        printSeparador("DEMOSTRACIÓN DINÁMICA: modificación en tiempo de ejecución");

        System.out.printf("%n  Consumo del campus ANTES del cambio: %.2f kWh (%.2f €)%n",
                campus.calcExpenses(), campus.calcExpenses() * PRECIO_KWH);

        // Se instala un nuevo proyector en el Aula 1 del aulario
        Device nuevoProyector = new Device(0.30, 6.0);
        aula1.addConsumer(nuevoProyector);
        System.out.println("  → Se instala un proyector en el Aula 1 (0.30 kWh × 6 h)");
        System.out.printf("  Consumo del campus DESPUÉS de instalar proyector: %.2f kWh (%.2f €)%n",
                campus.calcExpenses(), campus.calcExpenses() * PRECIO_KWH);

        // Se retira el proyector
        aula1.removeConsumer(nuevoProyector);
        System.out.println("  → Se retira el proyector del Aula 1");
        System.out.printf("  Consumo del campus TRAS retirar proyector:        %.2f kWh (%.2f €)%n",
                campus.calcExpenses(), campus.calcExpenses() * PRECIO_KWH);

        // ================================================================
        //  COMPARATIVA FINAL
        // ================================================================
        printSeparador("COMPARATIVA DE EDIFICIOS (consumo diario estimado)");
        System.out.println();
        printConsumo("Facultad de Informática",  facultadInformatica);
        printConsumo("Biblioteca Central",       biblioteca);
        printConsumo("Aulario General",          aulario);
        System.out.println("  ──────────────────────────────────────────────────────────────");
        printConsumo("TOTAL CAMPUS",             campus);
        System.out.println();
    }

    // ---------------------------------------------------------------
    // Helpers para construir espacios de forma compacta
    // ---------------------------------------------------------------

    /**
     * Crea un aula de prácticas con N puestos (PC + monitor + lámpara)
     * y opcionalmente un proyector.
     */
    private static Space buildAula(int puestos, boolean conProyector) {
        Space aula = new Space(new ArrayList<>());
        for (int i = 0; i < puestos; i++) {
            Space puesto = new Space(new ArrayList<>());
            puesto.addConsumer(new Device(0.20, 6.0));  // PC sobremesa
            puesto.addConsumer(new Device(0.03, 6.0));  // monitor
            aula.addConsumer(puesto);
        }
        // Iluminación general
        for (int i = 0; i < 4; i++) {
            aula.addConsumer(new Device(0.06, 8.0));    // fluorescente
        }
        if (conProyector) {
            aula.addConsumer(new Device(0.30, 6.0));    // proyector
        }
        return aula;
    }

    /**
     * Crea un aula teórica con N fluorescentes, un proyector
     * y climatización.
     */
    private static Space buildAulaTeoria(int fluorescentes, double horas) {
        Space aula = new Space(new ArrayList<>());
        for (int i = 0; i < fluorescentes; i++) {
            aula.addConsumer(new Device(0.06, horas));  // fluorescente
        }
        aula.addConsumer(new Device(0.30, horas));      // proyector
        aula.addConsumer(new Device(1.20, horas));       // climatización
        return aula;
    }
}
