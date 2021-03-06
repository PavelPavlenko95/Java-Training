package by.pavelpavlenko.task10.ex2.service;

import by.pavelpavlenko.task10.ex2.dao.Parser;
import by.pavelpavlenko.task10.ex2.dao.Writer;
import by.pavelpavlenko.task10.ex2.entity.Payment;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class Service {
    public void addProductToProductsList(String params, Payment payment) throws IllegalArgumentException {
        Validator validator = new Validator();
        ArrayList<String> paramsList;

        paramsList = parseLine(params);

        if (!validator.checkIsProductExists(paramsList.get(0), payment)) {
            throw new IllegalArgumentException("Данный товар уже существует!");
        }

        payment.addProductToProductsList(paramsList);
    }

    public void addProductToProductsList(List<String> params, Payment payment) throws IllegalArgumentException {
        Validator validator = new Validator();

        if (Double.parseDouble(params.get(2)) <= 0) {
            throw new IllegalArgumentException("Количество товара должно быть больше 0!");
        }

        if (!validator.checkIsProductExists(params.get(0), payment)) {
            throw new IllegalArgumentException("Данный товар уже существует!");
        }

        payment.addProductToProductsList(params);
    }

    public void addProductToPayment(List<String> params, Payment payment) throws NoSuchElementException, IllegalArgumentException {
        Validator validator = new Validator();
        List<Payment.Product> productsList = payment.getProductsList();
        boolean isMatch = false;
        double amountToBuy = Double.parseDouble(params.get(1));

        for (int i = 0; i < productsList.size(); ++i) {
            if (productsList.get(i).getName().equals(params.get(0))) {

                if (validator.checkIsAmountEnough(productsList.get(i), amountToBuy)) {
                    payment.addProductToSelectedProducts(productsList.get(i), amountToBuy);
                    productsList.get(i).reduceAmount(amountToBuy);

                    if (productsList.get(i).getAmount() == 0) {
                        productsList.remove(i);
                    }

                    isMatch = true;
                } else {
                    throw new IllegalArgumentException("Желаемое количество товара превышает доступное количество!");
                }
            }
        }
        if (!isMatch) {
            throw new NoSuchElementException("Товар не найден!");
        }
    }

    private double sumPriceOfProducts(List<Payment.Product> products) {
        double sum = 0.0;

        for (int i = 0; i < products.size(); ++i) {
            sum += products.get(i).getPrice() * products.get(i).getAmount();
        }

        return sum;
    }

    public String makePayment(Payment payment) throws NullPointerException {
        if (payment.getSelectedProducts().size() == 0) {
            throw new NullPointerException("Корзина пуста!");
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy hh:mm");
        List<Payment.Product> selectedProducts = payment.getSelectedProducts();

        StringBuilder paymentInfo = new StringBuilder();

        paymentInfo.append("Дата покупки \n");
        paymentInfo.append(dateFormat.format(date));
        paymentInfo.append("\n");
        paymentInfo.append("Список товаров: \n");

        for (int i = 0; i < selectedProducts.size(); ++i) {
            paymentInfo.append(makeStringParamsRow(selectedProducts.get(i)));
        }

        paymentInfo.append("Сумма покупки = ");
        paymentInfo.append(sumPriceOfProducts(selectedProducts));
        paymentInfo.append("\n");
        paymentInfo.append("Спасибо за покупку!");

        clearSelected(payment);

        return paymentInfo.toString();
    }

    public String makeStringParamsColumn(Payment.Product product) {
        StringBuilder params = new StringBuilder(150);

        params.append(product.getName());
        params.append("\n");
        params.append(product.getPrice());
        params.append("\n");
        params.append(product.getAmount());
        params.append("\n");
        params.append(product.getMeasure());
        params.append("\n");

        return params.toString();
    }

    public String makeStringParamsRow(Payment.Product product) {
        StringBuilder params = new StringBuilder(150);

        params.append(product.getName());
        params.append(" ");
        params.append(product.getPrice());
        params.append(" ");
        params.append(product.getAmount());
        params.append(" ");
        params.append(product.getMeasure());
        params.append("\n");

        return params.toString();
    }

    private void increaseAmountForPaymentCancel(Payment payment) {
        List<Payment.Product> productsAvailable = payment.getProductsList();
        List<Payment.Product> productsSelected = payment.getSelectedProducts();
        for (int i = 0; i < productsSelected.size(); ++i) {
            for (int j = 0; j < productsAvailable.size(); ++j) {
                if (productsSelected.get(i).getName().equals(productsAvailable.get(i).getName())) {
                    productsAvailable.get(i).increaseAmount(productsSelected.get(i).getAmount());
                }
            }
        }
    }

    public void removeProductFromProducts(List<String> params, Payment payment) throws NoSuchElementException {
        List<Payment.Product> products = payment.getProductsList();
        boolean isFound = false;

        for (int i = 0; i < products.size(); ++i) {
            if (products.get(i).getName().equals(params.get(0))) {
                products.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new NoSuchElementException("Данный товар не найден!");
        }
    }

    public String makeStringOfProducts(Payment payment) throws NullPointerException {
        if (payment.getProductsList().size() == 0) {
            throw new NullPointerException("Список товаров пуст!");
        }

        StringBuilder products_str = new StringBuilder();
        List<Payment.Product> products = payment.getProductsList();

        for (int i = 0; i < products.size(); ++i) {
            products_str.append(makeStringParamsRow(products.get(i)));
        }

        return products_str.toString();
    }

    public void eraseProducts(Payment payment) {
        payment.getProductsList().clear();
        payment.getSelectedProducts().clear();
    }

    public void clearSelected(Payment payment) {
        increaseAmountForPaymentCancel(payment);
        payment.getSelectedProducts().clear();
    }

    public void scanProductsFile(String filename, Payment payment) throws IOException {
        Parser parser = new Parser();
        ArrayList<String> params;

        List<String> list = parser.parseFile(filename);

        if (list.get(0).length() < 7) {
            throw new IOException("Файл пуст!");
        }

        for (int i = 0; i < list.size(); ++i) {
            params = parseLine(list.get(i));
            payment.addProductToProductsList(params);
        }
    }

    public void writeProductsListToFile(String filename, List<Payment.Product> products) throws IOException {
        Writer writer = new Writer();
        writer.writeProductsListToFile(filename, products, this);
    }

    private ArrayList<String> parseLine(String line) {
        ArrayList<String> params = new ArrayList<>();
        char paramDelimeter = ' ';
        int index = 0;

        for (int i = 0; i < 4; ++i) {
            index = line.indexOf(paramDelimeter);
            if (index != -1) {
                params.add(line.substring(0, index));
                line = line.substring(index + 1);
            } else {
                params.add(line);
            }
        }
        return params;
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
