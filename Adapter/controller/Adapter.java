package Adapter.controller;

import Adapter.model.MaquetadorAvanzado;
import Adapter.model.MaquetadorBasico;
import Adapter.model.Paragraph;
import java.io.*;
import java.util.*;

public class Adapter extends MaquetadorAvanzado {
    private MaquetadorBasico maquetadorBasico;

    public Adapter(MaquetadorBasico maquetadorBasico) {
        this.maquetadorBasico = maquetadorBasico;
    }

    @Override
    public void joinFiles(File file1, File file2) {
        try {
            //Leemos el contenido del archivo 2
            StringBuilder textFile2 = new StringBuilder();
            try(
                FileReader fr1 = new FileReader(file1);
                BufferedReader br1 = new BufferedReader(fr1);
            ){
                String line;
                while((line = br1.readLine()) != null) {
                    textFile2.append(line).append("\n");
                }
            }

            //Añadimos el contenido al archivo 1 usando el metodo de la clase MaquetadorBasico
            //Eliminamos el ultimo salto de línea si es necesario
            String textToAdd = textFile2.toString().trim();
            maquetadorBasico.addText(file1, textToAdd);

            System.out.println("Archivo "+ file1.getName() + " actualizado con el contenido del archivo " + file2.getName());
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    @Override
    public File combineParagraphs(File file1, Vector<Paragraph> vector1, File file2, Vector<Paragraph> vector2) {
        //Creamos un nuevo archivo para guardar el texto combinado
        File fileCombined = new File(file1.getParent() + File.separator + file1.getName().replace(".txt", "_combinado.txt"));

        try (FileWriter fw = new FileWriter(fileCombined);
            BufferedWriter bw = new BufferedWriter(fw);){

                int maxSize = Math.max(vector1.size(), vector2.size());

                for(int i = 0; i < maxSize; i++) {
                    //Añadir el contenido del archivo 1 en el caso de que exista
                    if(i < vector1.size()) {
                        Paragraph paragraph1 = vector1.get(i);
                        String paragraph = maquetadorBasico.extractParagraph(file1, paragraph1.getStartLine(), paragraph1.getEndLine());
                        bw.write(paragraph);

                        // Si el parrafo no termina con un salto de línea añadimos uno, menos en el caso de que sea el ultimo parrafo
                        if(!paragraph.endsWith("\n") && i < maxSize - 1) {
                            bw.newLine();
                        }
                    }

                    //Añadir el contenido del archivo 2 en el caso de que exista
                    if(i < vector2.size()) {
                        Paragraph paragraph2 = vector2.get(i);
                        String paragraph = maquetadorBasico.extractParagraph(file2, paragraph2.getStartLine(), paragraph2.getEndLine());
                        bw.write(paragraph);

                        // Si el parrafo no termina con un salto de línea añadimos uno, menos en el caso de que sea el ultimo parrafo
                        if(!paragraph.endsWith("\n") && i < maxSize - 1) {
                            bw.newLine();
                        }
                    }
                }

                System.out.println("Archivo " + fileCombined.getName() + " generado con el contenido de " + file1.getName() + " y " + file2.getName());

        }catch(IOException e) {
            System.err.println("Error al generar el archivo combinado: " + e.getMessage());
        }

        return fileCombined;
    }



    @Override
    public Vector<File> splitFiles(File file, Vector<Integer> splitPoints) {
        Vector<File> files = new Vector<>();
        File currentFile = file;

        try{
            //Ordenamos los puntos de división
            Vector<Integer> sortedSplitPoints = new Vector<>(splitPoints);
            Collections.sort(sortedSplitPoints);

            String originalName = file.getName().replace(".txt", "");
            String parentPath = file.getParent() != null ? file.getParent() + File.separator : "";

            for(int i = 0; i < sortedSplitPoints.size(); i++) {
                int splitLine = sortedSplitPoints.get(i);

                //Dividimos el archivo en dos partes 
                Vector<File> parts = maquetadorBasico.splitFile(currentFile, splitLine);

                if(parts.size() == 2) {
                    File upperFile = parts.get(0); //El archivo de la mitad superior
                    File lowerFile = parts.get(1); //El archivo de la mitad inferior

                    //El archivo de la parte inferior sera nuestro nuevo archivo actual
                    currentFile = lowerFile;

                    File savePart = new File(parentPath + originalName + "_parte" + (i + 1) + ".txt");
                    if(!upperFile.renameTo(savePart)) {
                        //Si no se pudo renombrar el archivo, copiamos el contenido del archivo a la nueva ubicación
                        copyFile(upperFile, savePart);
                        upperFile.delete();
                    }

                    files.add(i, savePart);
                }
            }


            //Guardamos el segmento restante 
            if(currentFile != file && currentFile.exists()) {
                File lastPart = new File(parentPath + originalName + "_parte" + (sortedSplitPoints.size() + 1) + ".txt");
                if(!currentFile.renameTo(lastPart)) {
                    copyFile(currentFile, lastPart);
                    currentFile.delete();
                }
                files.add(lastPart);
            }

            System.out.println("Archivos divididos en " + files.size() + " partes");

        }catch(IOException e) {
            System.err.println("Error al dividir el archivo: " + e.getMessage());
        }

        return files;

    }

    /**
    * Método auxiliar para copiar archivos
    */
    private void copyFile(File origin, File destiny) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(origin));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destiny))) {
            
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
        }
    }
}
