package Adapter;

import Adapter.controller.Adapter;
import Adapter.model.MaquetadorAvanzado;
import Adapter.model.MaquetadorBasico;
import Adapter.model.Paragraph;
import java.io.*;
import java.nio.file.*;
import java.util.Vector;

public class Main {

    private static final String FILES_PATH = "Adapter/Files/";

    public static void main(String[] args) {

        // Creamos el Adapter, que actúa como MaquetadorAvanzado usando internamente un MaquetadorBasico
        MaquetadorAvanzado maquetador = new Adapter(new MaquetadorBasico());

        demoJoinFiles(maquetador);
        demoCombineParagraphs(maquetador);
        demoSplitFiles(maquetador);
    }

    // =========================================================
    //  DEMO 1 — joinFiles
    //  Une el contenido de file2 al final de file1.
    //  Trabajamos con una copia para no modificar los originales.
    // =========================================================
    private static void demoJoinFiles(MaquetadorAvanzado maquetador) {
        printSeparator("DEMO 1: joinFiles");

        File file1 = new File(FILES_PATH + "Ladron de la virtud_Cap1_mitadSuperior.txt");
        File file2 = new File(FILES_PATH + "Ladron de la virtud_Cap1_mitadInferior.txt");

        if (!checkFiles(file1, file2)) return;

        // Copia del primer archivo para no alterar el original
        File copiaFile1 = copiarArchivo(file1, "Cap1_reunificado.txt");
        if (copiaFile1 == null) return;

        System.out.println("Uniendo:");
        System.out.println("    · " + file1.getName() + "  (mitad superior)");
        System.out.println("    · " + file2.getName() + "  (mitad inferior)");

        maquetador.joinFiles(copiaFile1, file2);

        System.out.println("\n--- Primeras 10 líneas del archivo resultante ---");
        imprimirPrimerasLineas(copiaFile1, 10);
        System.out.println("...");
        System.out.printf("%nArchivo generado: %s%n%n", copiaFile1.getName());
    }

    // =========================================================
    //  DEMO 2 — combineParagraphs
    //  Intercala párrafos de dos archivos distintos en uno nuevo.
    // =========================================================
    private static void demoCombineParagraphs(MaquetadorAvanzado maquetador) {
        printSeparator("DEMO 2: combineParagraphs");

        File file1 = new File(FILES_PATH + "Ladron de la virtud_Cap1.txt");
        File file2 = new File(FILES_PATH + "Ladron de la Virtud_Cap2.txt");

        if (!checkFiles(file1, file2)) return;

        // Párrafos que queremos extraer de cada archivo (líneas de inicio y fin)
        Vector<Paragraph> parrafos1 = new Vector<>();
        parrafos1.add(new Paragraph(1,  5));   // Líneas  1-5  del Cap1
        parrafos1.add(new Paragraph(11, 15));  // Líneas 11-15 del Cap1

        Vector<Paragraph> parrafos2 = new Vector<>();
        parrafos2.add(new Paragraph(1,  5));   // Líneas  1-5  del Cap2
        parrafos2.add(new Paragraph(11, 15));  // Líneas 11-15 del Cap2

        System.out.println("Combinando párrafos de:");
        System.out.println("    · " + file1.getName() + "  → líneas [1-5] y [11-15]");
        System.out.println("    · " + file2.getName() + "  → líneas [1-5] y [11-15]");

        File fileCombinado = maquetador.combineParagraphs(file1, parrafos1, file2, parrafos2);

        System.out.println("\n--- Contenido del archivo combinado ---");
        imprimirTodasLasLineas(fileCombinado);
        System.out.printf("%nArchivo generado: %s%n%n", fileCombinado.getName());
    }

    // =========================================================
    //  DEMO 3 — splitFiles
    //  Divide un archivo en varias partes usando múltiples puntos
    //  de corte. Cada punto se aplica sobre la porción restante.
    //  Ejemplo con [5, 5]:
    //    · parte1 → líneas  1-5  del original
    //    · parte2 → líneas  6-10 del original  (líneas 1-5 del resto)
    //    · parte3 → líneas 11+  del original   (el segmento final)
    // =========================================================
    private static void demoSplitFiles(MaquetadorAvanzado maquetador) {
        printSeparator("DEMO 3: splitFiles");

        File file = new File(FILES_PATH + "Receta de Cocina.txt");

        if (!checkFiles(file)) return;

        // Copia para no modificar el original
        File copiaFile = copiarArchivo(file, "Receta_COPIA.txt");
        if (copiaFile == null) return;

        // Puntos de corte: se aplican secuencialmente sobre el segmento restante
        Vector<Integer> puntosDivision = new Vector<>();
        puntosDivision.add(5);  // corte en línea 5 del archivo actual
        puntosDivision.add(5);  // corte en línea 5 del segmento restante (línea 10 del original)

        System.out.println("Dividiendo '" + file.getName() + "'");
        System.out.println("    Puntos de corte (aplicados sobre el segmento restante): " + puntosDivision);

        Vector<File> partes = maquetador.splitFiles(copiaFile, puntosDivision);

        System.out.println();
        for (int i = 0; i < partes.size(); i++) {
            File parte = partes.get(i);
            System.out.println("--- [Parte " + (i + 1) + "] " + parte.getName() + " ---");
            imprimirTodasLasLineas(parte);
            System.out.println();
        }

        System.out.printf("%d archivos generados.%n%n", partes.size());
    }

    // =========================================================
    //  Métodos auxiliares
    // =========================================================

    /** Crea una copia de un archivo en la misma carpeta con un nombre nuevo. */
    private static File copiarArchivo(File origen, String nuevoNombre) {
        File destino = new File(origen.getParent() + File.separator + nuevoNombre);
        try {
            Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return destino;
        } catch (IOException e) {
            System.err.println("Error al crear la copia temporal: " + e.getMessage());
            return null;
        }
    }

    /** Comprueba que todos los archivos pasados existen. */
    private static boolean checkFiles(File... archivos) {
        for (File f : archivos) {
            if (!f.exists()) {
                System.out.println("Archivo no encontrado: " + f.getAbsolutePath());
                return false;
            }
        }
        return true;
    }

    /** Imprime las primeras {@code max} líneas de un archivo. */
    private static void imprimirPrimerasLineas(File file, int max) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null && contador < max) {
                System.out.println(linea);
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /** Imprime todas las líneas de un archivo. */
    private static void imprimirTodasLasLineas(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /** Imprime una cabecera de sección. */
    private static void printSeparator(String titulo) {
        String linea = "=".repeat(55);
        System.out.println(linea);
        System.out.println("  " + titulo);
        System.out.println(linea);
    }
}
