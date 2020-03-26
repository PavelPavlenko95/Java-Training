package by.pavelpavlenko.xml.service.parser;

import by.pavelpavlenko.xml.dao.DAOImpl;
import by.pavelpavlenko.xml.entity.Category;
import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class PortalDomParser extends AbstractPortalParser {
    private static final String LECTURE = "lecture";
    private static final String ID = "id";
    private static final String NAME = "lectures.name";
    private static final String CATEGORY = "category";
    private static final String LINK = "lectures.link";
    private static final String LENGTH = "lectures.length";
    private static final String TESTS = "lectures.tests";
    private static final String DATE = "lectures.date";

    @Override
    public void buildListLectures(File file, String path) throws XMLFileException, WrongFileException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DAOImpl daoParser = new DAOImpl();
            Schema schema = factory.newSchema(daoParser.getFile(path));
            documentBuilderFactory.setSchema(schema);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element element = document.getDocumentElement();
            NodeList lecturesNodeList = element.getElementsByTagName(LECTURE);
            schema = factory.newSchema(new File(path));
            for (int i = 0; i < lecturesNodeList.getLength(); i++) {
                Element lectureElement = (Element) lecturesNodeList.item(i);
                Lecture lecture = parseLecture(lectureElement);
                super.getLectures().add(lecture);
            }
        } catch (IOException | SAXException | ParserConfigurationException e) {
            throw new XMLFileException(e);
        }
    }

    private Lecture parseLecture(Element lectureElement) {
        Lecture lecture = new Lecture();
        lecture.setId(lectureElement.getAttribute(ID));
        lecture.setName(getElementTextContent(lectureElement, NAME));

        Category category = new Category();
        category.setName(getElementTextContent(lectureElement, CATEGORY));
        category.setId(lectureElement.getAttribute(ID));

        lecture.setDate(getElementTextContent(lectureElement, DATE));

        boolean tests = Boolean.valueOf(getElementTextContent(lectureElement, TESTS));
        lecture.setTests(tests);

        float length = Float.parseFloat(getElementTextContent(lectureElement, LENGTH));
        lecture.setLength(length);

        String link = getElementTextContent(lectureElement, LINK);
        lecture.setLink(link);

        return lecture;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String textContent = node.getTextContent();
        return textContent;
    }
}