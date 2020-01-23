package by.pavelpavlenko.task10.ex1.controller.command.impl;

import by.pavelpavlenko.task10.ex1.controller.command.Command;
import by.pavelpavlenko.task10.ex1.entity.TextFile;
import by.pavelpavlenko.task10.ex1.service.Service;
import by.pavelpavlenko.task10.ex1.validator.Validator;

import java.util.ArrayList;

public class Rename implements Command {
    @Override
    public String execute(String request, TextFile textFile) {
        Validator validator = new Validator();
        Service service = new Service();

        String errorMsg = "Не удалось переименовать файл!";
        String successMsg = "Файл переименован успешно!";


        ArrayList<String> params = service.parseRequest(request);

        if (params.size() < 3) {
            return errorMsg;
        }

        String dir =  params.get(0);
        String filename = params.get(1);

        if (!validator.checkDir(dir)) {
            return errorMsg;
        }

        if (!validator.checkFile(dir, filename)) {
            return errorMsg;
        }

        textFile.setPathStrings(dir, filename);

        String newFilename = params.get(2);

        if (!validator.checkFileFormat(newFilename)) {
            return errorMsg;
        }

        try {
            service.renameFile(textFile, newFilename);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return successMsg;
    }

}
