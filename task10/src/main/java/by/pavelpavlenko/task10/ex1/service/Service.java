package by.pavelpavlenko.task10.ex1.service;

import by.pavelpavlenko.task10.ex1.entity.TextFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Service {
    public void createFile(TextFile textFile) throws IOException {
        java.io.File file = new java.io.File(textFile.getFullPath().getAbsolutePath());
        if (!file.createNewFile()) {
            throw new IOException("Не удалось создать новый файл!");
        }
    }

    public void renameFile(TextFile textFile, String newFilename) throws Exception {
        java.io.File newName = new java.io.File(textFile.getDir(), newFilename);
        if (!textFile.getFullPath().renameTo(newName)) {
            throw new IOException("Не удалось переименовать файл!");
        }
    }

    public void deleteFile(TextFile textFile) throws IOException {
        if (!textFile.getFullPath().delete()) {
            throw new IOException("Не удалось удалить файл!");
        }
    }

    public void eraseFile(TextFile textFile) throws IOException {
        FileWriter fileWriter = new FileWriter(textFile.getFullPath(), false);

        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write("");

        } catch (IOException ex) {
            throw new IOException("Не удалось очистить файл");
        }
    }

    public ArrayList<String> parseRequest(String request) {
        char paramDelimeter = ' ';
        ArrayList<String> params = new ArrayList<>();

        int index = 0;

        while (index != -1) {
            index = request.indexOf(paramDelimeter);
            if (index != -1) {
                params.add(request.substring(0, index));
                if (index + 1 < request.length()) {
                    request = request.substring(index + 1, request.length());
                } else {
                    return params;
                }
            } else {
                params.add(request);
            }
        }
        return params;
    }

}

