package by.pavelpavlenko.xml.controller;

import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;
import by.pavelpavlenko.xml.service.parser.AbstractPortalParser;
import by.pavelpavlenko.xml.service.parser.factory.PortalParserFactory;
import by.pavelpavlenko.xml.tags.VendorMap;
import org.apache.commons.io.FileUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

@MultipartConfig
public class ParserServlet extends HttpServlet {

    public void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        req.setAttribute("user", "Administrator");
        VendorMap map = new VendorMap();
        req.setAttribute("rw", map);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

            String schema = "D:\\gitrep\\Task3_XML_XSD_PARSING\\src\\main\\resources\\schema.xsd";
            String parser;
            String language;

            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(req.getPart("language").getInputStream()));
            language = bufferedReader1.readLine();
            bufferedReader1.close();

            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(req.getPart("typeOfParser").getInputStream()));
            parser = bufferedReader2.readLine();
            bufferedReader2.close();

            File file = File.createTempFile("txt", "txt", new File("D:\\gitrep\\Task3_XML_XSD_PARSING\\src\\main\\resources"));
            FileUtils.copyInputStreamToFile(req.getPart("file").getInputStream(), file);


        try {
            AbstractPortalParser portalParser = new PortalParserFactory().parseXML(parser);
            portalParser.buildListLectures(file, schema);
            ArrayList<Lecture> arrayList =  portalParser.getLectures();
            Locale locale = null;
            if ("russian".equals(language)) {
                locale = new Locale("ru");
            }
            if ("english".equals(language)) {
                locale = new Locale("en");
            }

            ResourceBundle resourceBundle = ResourceBundle.getBundle("text", locale, new UTF8Control());

            req.setAttribute("name", resourceBundle.getString("lectures.name"));
            req.setAttribute("type", resourceBundle.getString("lectures.type"));
            req.setAttribute("link", resourceBundle.getString("lectures.link"));
            req.setAttribute("length", resourceBundle.getString("lectures.length"));
            req.setAttribute("tests", resourceBundle.getString("lectures.tests"));
            req.setAttribute("date", resourceBundle.getString("lectures.date"));
            req.setAttribute("typeOfParser", parser);
            req.setAttribute("lecturesList", arrayList);
            System.out.println(arrayList);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        } catch (XMLFileException e) {
            e.printStackTrace();
        } catch (WrongFileException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        }
}

