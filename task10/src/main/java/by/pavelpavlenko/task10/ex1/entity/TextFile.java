package by.pavelpavlenko.task10.ex1.entity;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFile extends FileEntity {

    public TextFile(String dir, String filename) {
        super(dir, filename);
    }

    public TextFile(java.io.File dir, java.io.File filename) {
        super(dir, filename);
    }

    public TextFile(java.io.File dir, String filename) {
        super(dir, filename);
    }

    public TextFile(String dir, java.io.File filename) {
        super(dir, filename);
    }

    public TextFile() {
        super();
    }

    @Override
    public String getContent() throws IOException {
        return new String(Files.readAllBytes(Paths.get(getFullPath().getAbsolutePath())));
    }

    @Override
    public void addInfo(String info) throws IOException {
        try (FileWriter writer = new FileWriter(getFullPath().getAbsolutePath(), true)) {
            writer.write(info + "\n");
            writer.flush();
        } catch (IOException ex) {
            throw new IOException("Не удалось добавить информацию!", ex);
        }
    }

    @Override
    public String toString() {
        return "TextFile{}";
    }
}
