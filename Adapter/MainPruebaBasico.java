package Adapter; // O el paquete donde quieras poner tu Main de prueba

import Adapter.model.MaquetadorBasico;
import java.io.File;
import java.util.Vector;

public class MainPruebaBasico {

    public static void main(String[] args) {

        // 1. Creamos una instancia de tu MaquetadorBasico
        MaquetadorBasico maquetador = new MaquetadorBasico();

        // 2. Apuntamos a uno de los archivos de texto que tienes en tu proyecto.
        // OJO: La ruta relativa puede variar dependiendo de desde dónde ejecutes tu IDE.
        // Si no lo encuentra, prueba con "src/Adapter/Files/Receta de Cocina.txt"
        File archivo = new File("Adapter/Files/Ladron de la virtud_Cap1.txt");

        // 3. Pequeña comprobación para asegurarnos de que Java encuentra el archivo
        if (!archivo.exists()) {
            System.out.println("❌ No se ha encontrado el archivo en la ruta: " + archivo.getAbsolutePath());
            return;
        }

        System.out.println("✅ Archivo encontrado. Procediendo a extraer...");

        // 4. Probamos la función extractParagraph y splitFile.
        // Vamos a intentar sacar de la línea 1 a la 3
        int inicio = 1;
        int fin = 3;
        int splitLine = 10;

        String resultado = maquetador.extractParagraph(archivo, inicio, fin);
        Vector<File> resultadoSplit = maquetador.splitFile(archivo, splitLine);

        // 5. Imprimimos el resultado
        System.out.println("\n--- PÁRRAFO EXTRAÍDO (Líneas " + inicio + " a " + fin + ") ---");
        System.out.println(resultado);
        System.out.println("----------------------------------------");

        System.out.println("\n--- PÁRRAFO EXTRAÍDO SUPERIOR SPLIT ---");
        System.out.println(resultadoSplit.getFirst());
        System.out.println("----------------------------------------");

        System.out.println("\n--- PÁRRAFO EXTRAÍDO INFERIOR SPLIT ---");
        System.out.println(resultadoSplit.getLast());
        System.out.println("----------------------------------------");
    }
}