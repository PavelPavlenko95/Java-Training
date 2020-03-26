package services;

import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;
import by.pavelpavlenko.xml.service.parser.AbstractPortalParser;
import by.pavelpavlenko.xml.service.parser.factory.PortalParserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class PortalSAXBuilderTest {

    @DataProvider(name = "values")
    public Object[][] values() {
        return new Object[][]{
                {"1-name","Second"},
                {"2-type","Lecture"},
                {"3-link","youtube.com/123"},
                {"4-length","65.34"},
                {"5-tests","true"},
                {"6-date","01.11.2019"}
        };
    }

    @Test(description = "validation of the SAX parsing", dataProvider = "values" )
    public void testSAXParser(String a, String b) throws XMLFileException, FileNotFoundException, WrongFileException, XMLStreamException {

        PortalParserFactory portalParserFactory = new PortalParserFactory();
        AbstractPortalParser lectureBuilder = portalParserFactory.parseXML("SAX");
        lectureBuilder.buildListLectures(new File("src/main/resources/trainingPortal.xml"),"src/main/resources/schema.xsd");
        ArrayList<Lecture> lectures = lectureBuilder.getLectures();

        int number = Integer.valueOf(a.split("-")[0]);
        executeRequest(a.split("-")[1],lectures.get(number));

        String expected = b;
        String actual = executeRequest(a.split("-")[1],lectures.get(number));
        assertEquals(actual,expected);
    }

    private String executeRequest(String req, Lecture lecture) {

        switch (req) {
            case "name" : return lecture.getName();
            case "type" : return lecture.getLectureType();
            case "link" : return lecture.getLink();
            case "length" : return String.valueOf(lecture.getLength());
            case "tests" : return String.valueOf(lecture.getTests());
            case "date" : return lecture.getDate();
        }
        return null;
    }


}
