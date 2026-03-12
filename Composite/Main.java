package Composite;

import Composite.model.Consumer;
import Composite.model.Device;
import Composite.model.Space;
import java.util.ArrayList;

public class Main {

    // ---------------------------------------------------------------
    // Utilidad: imprime el consumo de un Consumer con etiqueta
    // ---------------------------------------------------------------
    private static void printExpenses(String label, Consumer consumer) {
        System.out.printf("  %-40s -> %.2f kWh%n", label, consumer.calcExpenses());
    }

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║        PATRÓN COMPOSITE – Gestión de Consumo Eléctrico  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        // ================================================================
        // CONFIGURACIÓN 1: Apartamento pequeño (1 planta, 2 habitaciones)
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println(" CONFIGURACIÓN 1: Apartamento pequeño");
        System.out.println("══════════════════════════════════════════════════════════");

        // — Dormitorio —
        Device televisorDorm  = new Device(0.10, 3.0);   // 0.10 kWh/h, 3 h/día
        Device lamparaDorm    = new Device(0.06, 5.0);   // bombilla LED 60W
        Device ordenador      = new Device(0.30, 4.0);   // portátil

        Space dormitorio = new Space(new ArrayList<>());
        dormitorio.addConsumer(televisorDorm);
        dormitorio.addConsumer(lamparaDorm);
        dormitorio.addConsumer(ordenador);

        // — Cocina —
        Device frigorifico    = new Device(0.15, 24.0);  // siempre encendido
        Device microondas     = new Device(1.20, 0.5);   // 30 min/día
        Device lavadora       = new Device(2.00, 1.0);   // 1 h/día

        Space cocina = new Space(new ArrayList<>());
        cocina.addConsumer(frigorifico);
        cocina.addConsumer(microondas);
        cocina.addConsumer(lavadora);

        // — Apartamento = dormitorio + cocina —
        Space apartamento = new Space(new ArrayList<>());
        apartamento.addConsumer(dormitorio);
        apartamento.addConsumer(cocina);

        System.out.println("\n  [Dispositivos individuales]");
        printExpenses("Televisor (dormitorio)",    televisorDorm);
        printExpenses("Lámpara   (dormitorio)",    lamparaDorm);
        printExpenses("Ordenador (dormitorio)",    ordenador);
        printExpenses("Frigorífico (cocina)",      frigorifico);
        printExpenses("Microondas  (cocina)",      microondas);
        printExpenses("Lavadora    (cocina)",      lavadora);

        System.out.println("\n  [Espacios]");
        printExpenses("Dormitorio",                dormitorio);
        printExpenses("Cocina",                    cocina);

        System.out.println("\n  [Total apartamento]");
        printExpenses("Apartamento completo",      apartamento);

        // ================================================================
        // CONFIGURACIÓN 2: Casa con dos plantas
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println(" CONFIGURACIÓN 2: Casa unifamiliar (2 plantas)");
        System.out.println("══════════════════════════════════════════════════════════");

        // — Planta baja —
        Device tvSalon        = new Device(0.15, 4.0);
        Device consola        = new Device(0.20, 2.0);
        Device lampSalon      = new Device(0.10, 6.0);
        Device horno          = new Device(2.00, 1.0);
        Device lavavajillas   = new Device(1.80, 1.5);

        Space salon = new Space(new ArrayList<>());
        salon.addConsumer(tvSalon);
        salon.addConsumer(consola);
        salon.addConsumer(lampSalon);

        Space cocinaPlantaBaja = new Space(new ArrayList<>());
        cocinaPlantaBaja.addConsumer(new Device(0.15, 24.0)); // frigorífico
        cocinaPlantaBaja.addConsumer(horno);
        cocinaPlantaBaja.addConsumer(lavavajillas);

        Space plantaBaja = new Space(new ArrayList<>());
        plantaBaja.addConsumer(salon);
        plantaBaja.addConsumer(cocinaPlantaBaja);

        // — Primera planta —
        Device lampDorm1      = new Device(0.06, 6.0);
        Device lampDorm2      = new Device(0.06, 4.0);
        Device aireAcond      = new Device(1.50, 3.0);   // aire acondicionado
        Device cargadorMovil  = new Device(0.01, 8.0);

        Space dormitorio1 = new Space(new ArrayList<>());
        dormitorio1.addConsumer(lampDorm1);
        dormitorio1.addConsumer(aireAcond);
        dormitorio1.addConsumer(cargadorMovil);

        Space dormitorio2 = new Space(new ArrayList<>());
        dormitorio2.addConsumer(lampDorm2);
        dormitorio2.addConsumer(new Device(0.10, 2.0)); // TV pequeña

        Space primeraPlanta = new Space(new ArrayList<>());
        primeraPlanta.addConsumer(dormitorio1);
        primeraPlanta.addConsumer(dormitorio2);

        // — Casa completa —
        Space casaUnifamiliar = new Space(new ArrayList<>());
        casaUnifamiliar.addConsumer(plantaBaja);
        casaUnifamiliar.addConsumer(primeraPlanta);

        System.out.println("\n  [Plantas]");
        printExpenses("Planta baja",               plantaBaja);
        printExpenses("Primera planta",            primeraPlanta);

        System.out.println("\n  [Total casa unifamiliar]");
        printExpenses("Casa unifamiliar completa", casaUnifamiliar);

        // ================================================================
        // CONFIGURACIÓN 3: Edificio de oficinas (3 plantas con despachos)
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println(" CONFIGURACIÓN 3: Edificio de oficinas (3 plantas)");
        System.out.println("══════════════════════════════════════════════════════════");

        // Planta 0 – Recepción + sala de reuniones
        Space recepcion = buildOfficeRoom(3, 0.06, 8.0, 0.20, 8.0);  // 3 lámparas + PC recepción
        Space salaReuniones = buildOfficeRoom(6, 0.06, 4.0, 0.10, 4.0);

        Space planta0 = new Space(new ArrayList<>());
        planta0.addConsumer(recepcion);
        planta0.addConsumer(salaReuniones);
        planta0.addConsumer(new Device(0.50, 24.0)); // servidor pequeño

        // Planta 1 – Despachos
        Space planta1 = buildOpenOffice(5);  // 5 puestos de trabajo

        // Planta 2 – Dirección
        Space planta2 = buildOpenOffice(3);
        planta2.addConsumer(new Device(2.00, 8.0)); // proyector

        Space edificioOficinas = new Space(new ArrayList<>());
        edificioOficinas.addConsumer(planta0);
        edificioOficinas.addConsumer(planta1);
        edificioOficinas.addConsumer(planta2);

        System.out.println("\n  [Plantas del edificio]");
        printExpenses("Planta 0 (Recepción/Reuniones)", planta0);
        printExpenses("Planta 1 (Oficina abierta)",     planta1);
        printExpenses("Planta 2 (Dirección)",           planta2);

        System.out.println("\n  [Total edificio de oficinas]");
        printExpenses("Edificio de oficinas completo",  edificioOficinas);

        // ================================================================
        // DEMOSTRACIÓN DINÁMICA: añadir y eliminar dispositivos
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println(" DEMOSTRACIÓN DINÁMICA: modificación en tiempo de ejecución");
        System.out.println("══════════════════════════════════════════════════════════");

        System.out.printf("%n  Consumo del apartamento ANTES de añadir dispositivo: %.2f kWh%n",
                apartamento.calcExpenses());

        Device secador = new Device(2.00, 0.25); // secador de pelo, 15 min/día
        dormitorio.addConsumer(secador);
        System.out.printf("  → Se añade secador de pelo al dormitorio (2.0 kWh × 0.25 h)%n");
        System.out.printf("  Consumo del apartamento DESPUÉS de añadir dispositivo: %.2f kWh%n",
                apartamento.calcExpenses());

        dormitorio.removeConsumer(secador);
        System.out.printf("  → Se elimina el secador%n");
        System.out.printf("  Consumo del apartamento TRAS eliminar dispositivo:    %.2f kWh%n",
                apartamento.calcExpenses());

        // ================================================================
        // COMPARATIVA FINAL
        // ================================================================
        System.out.println("\n══════════════════════════════════════════════════════════");
        System.out.println(" COMPARATIVA DE CONFIGURACIONES (consumo diario estimado)");
        System.out.println("══════════════════════════════════════════════════════════\n");
        printExpenses("Apartamento pequeño",           apartamento);
        printExpenses("Casa unifamiliar",              casaUnifamiliar);
        printExpenses("Edificio de oficinas",          edificioOficinas);
        System.out.println();
    }

    // ---------------------------------------------------------------
    // Helpers para construir espacios de forma compacta
    // ---------------------------------------------------------------

    /**
     * Crea un despacho/sala con N lámparas y un PC por puesto.
     */
    private static Space buildOfficeRoom(int lamps,
                                         double lampConsumption, double lampHours,
                                         double pcConsumption,   double pcHours) {
        Space room = new Space(new ArrayList<>());
        for (int i = 0; i < lamps; i++) {
            room.addConsumer(new Device(lampConsumption, lampHours));
        }
        room.addConsumer(new Device(pcConsumption, pcHours));
        return room;
    }

    /**
     * Crea una planta de oficina abierta con N puestos de trabajo
     * (cada puesto: 1 PC + 1 monitor + 1 lámpara).
     */
    private static Space buildOpenOffice(int workstations) {
        Space floor = new Space(new ArrayList<>());
        for (int i = 0; i < workstations; i++) {
            Space workstation = new Space(new ArrayList<>());
            workstation.addConsumer(new Device(0.20, 8.0));  // PC de sobremesa
            workstation.addConsumer(new Device(0.03, 8.0));  // monitor
            workstation.addConsumer(new Device(0.06, 8.0));  // lámpara de escritorio
            floor.addConsumer(workstation);
        }
        return floor;
    }
}
