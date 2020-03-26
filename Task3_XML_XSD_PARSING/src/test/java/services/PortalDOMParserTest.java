package services;

import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;
import by.pavelpavlenko.xml.service.parser.PortalDomParser;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PortalDOMParserTest {

    File file;

    public PortalDomParser domParser = new PortalDomParser();

    public PortalDOMParserTest() throws XMLFileException {
    }

    List<String> paths = Arrays.asList("src\\main\\resources\\trainingPortal.xml",
            "src\\main\\resources\\emptyFile.xml",
            "src\\main\\resources\\wrongPortal.xml",
            "wrongPath.xml");

    @Test
    public void parse() throws WrongFileException, XMLFileException {
        domParser.buildListLectures(file, paths.get(0));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseEmptyFile() throws XMLFileException, WrongFileException {
        domParser.buildListLectures(file, paths.get(1));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongFile() throws WrongFileException, XMLFileException {
        domParser.buildListLectures(file, paths.get(2));
    }

    @Test(expectedExceptions = XMLFileException.class)
    public void parseWrongPath() throws XMLFileException, WrongFileException {
        domParser.buildListLectures(file, paths.get(3));
    }


}
