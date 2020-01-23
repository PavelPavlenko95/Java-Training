package by.pavelpavlenko.task10.ex2.dao;

import by.pavelpavlenko.task10.ex2.entity.Payment;
import by.pavelpavlenko.task10.ex2.service.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public void writeProductsListToFile(String filename, List<Payment.Product> products, Service service) throws IOException {
        File file = new File(filename);

        try (FileWriter writer = new FileWriter(file, false)) {

            for (int i = 0; i < products.size(); ++i) {
                writer.write(service.makeStringParamsRow(products.get(i)));
            }

            writer.flush();

        } catch (IOException ex) {
            throw new IOException("Не удалось добавить информацию!", ex);
        }
    }
}
