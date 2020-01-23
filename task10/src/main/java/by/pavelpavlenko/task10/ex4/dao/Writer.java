package by.pavelpavlenko.task10.ex4.dao;

import by.pavelpavlenko.task10.ex4.entity.DragonTreasure;
import by.pavelpavlenko.task10.ex4.service.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public void writeProductsListToFile(String filename, List<DragonTreasure.Treasure> products, Service service) throws IOException {
        File file = new File(filename);

        try (FileWriter writer = new FileWriter(file, false)) { // try с параметрами для закрытия потока

            for (int i = 0; i < products.size(); ++i) {                 // записывам параметры товара в файл
                writer.write(service.makeStringParamsRow(products.get(i)));
            }

            writer.flush();

        } catch (IOException ex) {
            throw new IOException("Не удалось добавить информацию!", ex); // если возникла ошибка записи
        }
    }
}
