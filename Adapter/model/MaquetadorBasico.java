package Adapter.model;

import java.io.*;
import java.util.Vector;

public class MaquetadorBasico {
    //Funcion para añadir texto
    void addText(File file, String text) {

        //Usaremos un try with resources para evitar usar finally despues del catch
        //asi acortaremos el código.

        // El 'true' en el FileWriter indica que queremos añadir al final (append mode)
        try (FileWriter fw = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            out.println(text);

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    //Funcion para obtener un párrafo, pasando línea de inicio y final
    String extractParagraph(File file, int start, int end) {
        //Implementar
    }

    Vector<File> splitFile(File file, int splitLine) {
        //Implementar
    }
}
