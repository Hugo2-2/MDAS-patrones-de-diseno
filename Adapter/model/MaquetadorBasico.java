package Adapter.model;

import java.io.*;
import java.util.Vector;

public class MaquetadorBasico {
    //Funcion para añadir texto
    public void addText(File file, String text) {

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
    public String extractParagraph(File file, int start, int end) {
        StringBuilder paragraph = new StringBuilder();
        try ( FileReader fr = new FileReader(file);
              BufferedReader br = new BufferedReader(fr);) {

            String line;
            int currentLineNumber = 1;
            while ((line = br.readLine()) != null) {

                if(currentLineNumber >= start && currentLineNumber <= end) {
                    paragraph.append(line).append("\n"); //Insertamos en el apéndice del párrafo
                }
                if(currentLineNumber > end) {
                    break;
                }
                currentLineNumber++;
            }


        } catch (IOException e) {
            System.err.println("Error al extraer párrafo en el archivo: " + e.getMessage());
        }

        return paragraph.toString();
    }

    public Vector<File> splitFile(File file, int splitLine) {
        StringBuilder upperParagraph = new StringBuilder();
        StringBuilder lowerParagraph = new StringBuilder();
        try ( FileReader fr = new FileReader(file);
              BufferedReader br = new BufferedReader(fr);) {

            String line;
            int currentLineNumber = 1;
            while ((line = br.readLine()) != null) {

                if(currentLineNumber <= splitLine) {
                    upperParagraph.append(line).append("\n"); //Insertamos en la mitad superior del texto
                }
                if(currentLineNumber > splitLine) {
                    lowerParagraph.append(line).append("\n"); //Insertamos en la mitad inferior del texto
                }
                currentLineNumber++;
            }


        } catch (IOException e) {
            System.err.println("Error al dividir el texto: " + e.getMessage());
        }

        // Vamos a quitar la extensión ".txt" del nombre original si la tiene, para que quede mejor
        String originalName = file.getName().replace(".txt", "");

        // Si el archivo estaba en una carpeta, cogemos esa misma carpeta para guardar los nuevos
        String parentPath = file.getParent() != null ? file.getParent() + File.separator : "";

        //Para generar el file debemos pasarle un path para saber donde ubicarse
        File upperFile = new File(parentPath + originalName + "_mitadSuperior.txt");
        File lowerFile = new File(parentPath + originalName + "_mitadInferior.txt");

        //Escribimos el contenido en los archivos
        try (FileWriter fwUpper = new FileWriter(upperFile);
             FileWriter fwLower = new FileWriter(lowerFile)) {

            fwUpper.write(upperParagraph.toString());
            fwLower.write(lowerParagraph.toString());

        } catch (IOException e) {
            System.err.println("Error al guardar los archivos divididos: " + e.getMessage());
        }

        Vector<File> filesVector =  new Vector<>();
        filesVector.add(upperFile);
        filesVector.add(lowerFile);

        return filesVector;
    }
}
