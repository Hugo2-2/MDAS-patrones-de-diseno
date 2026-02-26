package Adapter.model;

public class Paragraph {
    int startLine;
    int endLine;

    public Paragraph(int startLine, int endLine) {
        this.startLine = startLine;
        this.endLine = endLine;
    }

    public int getEndLine() {
        return endLine;
    }

    public void setEndLine(int endLine) {
        this.endLine = endLine;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }
}
