package by.pavelpavlenko.xml.service.parser;

import by.pavelpavlenko.xml.entity.Category;
import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.entity.LectureType;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PortalStaxParser extends AbstractPortalParser {
    private ArrayList<Lecture> lectures = new ArrayList<>();
    private Lecture lecture = null;
    private Category category = null;
    private LectureType lectureType = null;
    private XMLInputFactory inputFactory;
    private String content = null;
    private static final String DEFAULT_UNIT = "mg";

    public PortalStaxParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    @Override
    public void buildListLectures(File file, String path) throws WrongFileException, XMLFileException {
        FileInputStream inputStream;
        XMLStreamReader reader;
        try {
            inputStream = new FileInputStream(new File(path));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "lecture":
                                lecture = new Lecture();
                                lecture.setId(reader.getAttributeValue(0));
                                break;
                            case "category":
                                category = new Category();
                                category.setId(reader.getAttributeValue(0));
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        content = reader.getText().trim();
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "lecture":
                                lectures.add(lecture);
                                break;
                            case "name":
                                lecture.setName(content);
                                break;
                            case "type":
                                lecture.setLectureType(content);
                                break;
                            case "link":
                                lecture.setLink(content);
                                break;
                            case "length":
                                lecture.setLength(Float.parseFloat(content));
                                break;
                            case "tests":
                                lecture.setTests(Boolean.valueOf(content));
                                break;
                            case "date":
                                lecture.setDate(content);
                                break;
                            case "category":
                                category.setName(content);
                                break;
                        }
                        break;
                    case XMLStreamReader.START_DOCUMENT:
                        lectures = new ArrayList<>();
                        break;
                }
            }
        } catch (XMLStreamException e) {
            throw new XMLFileException(e);
        } catch (FileNotFoundException e) {
            throw new WrongFileException(e);
        }
        super.getLectures().add(lecture);
    }

}