package by.pavelpavlenko.xml.service.parser;

import by.pavelpavlenko.xml.dao.DAOImpl;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;
import by.pavelpavlenko.xml.service.handler.LectureHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class PortalSaxParser extends AbstractPortalParser {

    @Override
    public void buildListLectures(File file, String path) throws XMLFileException, WrongFileException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        Schema schema;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {

            DAOImpl daoParser = new DAOImpl();
            schema = factory.newSchema(daoParser.getFile(path));
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setSchema(schema);
            SAXParser saxParser = parserFactory.newSAXParser();
            saxParser.parse(file, new LectureHandler(super.getLectures()));
        } catch (ParserConfigurationException e) {
            throw new XMLFileException(e);
        } catch (IOException e) {
            throw new WrongFileException(e);
        } catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
    }
}
