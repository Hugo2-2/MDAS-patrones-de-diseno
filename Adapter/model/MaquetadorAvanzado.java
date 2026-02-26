package Adapter.model;

import java.io.File;
import java.util.Vector;

public abstract class MaquetadorAvanzado {
    public abstract void joinFiles(File file1, File file2);
    public abstract void combineParagraphs(File file1, Vector<Paragraph> vector1, File file2, Vector<Paragraph> vector2);
    public abstract Vector<File> splitFiles();
}
