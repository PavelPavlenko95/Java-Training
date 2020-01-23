package by.pavelpavlenko.task10.ex1.entity;

import java.io.IOException;
import java.util.Objects;

public abstract class FileEntity {
    private Directory dir;
    private java.io.File filename;

    public FileEntity(String dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public FileEntity(java.io.File dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public FileEntity(java.io.File dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public FileEntity(String dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public FileEntity() {
        dir = null;
        filename = null;
    }

    public java.io.File getFilename() {
        return filename;
    }

    public java.io.File getDir() {
        return dir.getDir();
    }

    public java.io.File getFullPath() {
        return new java.io.File(dir.getDir(), filename.getName());
    }

    public void setPathFiles(java.io.File dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public void setPathStrings(String dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public void setPathFileString(java.io.File dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public void setPathStringFile(String dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public abstract String getContent() throws IOException;

    public abstract void addInfo(String info) throws IOException;

    public class Directory {
        private java.io.File dir;

        public Directory(String dir_name) {
            dir = new java.io.File(dir_name);
        }

        public Directory(java.io.File dir) {
            this.dir = dir;
        }

        public Directory() {
            dir = null;
        }

        public java.io.File getDir() {
            return dir;
        }

        public void setDirString(String dir) {
            this.dir = new java.io.File(dir);
        }

        public void setDirFile(java.io.File dir) {
            this.dir = dir;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEntity)) return false;
        FileEntity that = (FileEntity) o;
        return Objects.equals(getDir(), that.getDir()) &&
                Objects.equals(getFilename(), that.getFilename());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDir(), getFilename());
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "dir=" + dir +
                ", filename=" + filename +
                '}';
    }
}
