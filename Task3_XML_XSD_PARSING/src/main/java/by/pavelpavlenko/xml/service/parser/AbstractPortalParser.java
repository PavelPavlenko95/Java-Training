package by.pavelpavlenko.xml.service.parser;

import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.exception.WrongFileException;
import by.pavelpavlenko.xml.exception.XMLFileException;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPortalParser {
    private ArrayList<Lecture> lectures;

    public AbstractPortalParser() {
        lectures = new ArrayList<>();
    }

    public AbstractPortalParser(ArrayList<Lecture> lectures) {
        this.lectures = lectures;
    }

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    abstract public void buildListLectures(File file, String path) throws XMLFileException, WrongFileException, FileNotFoundException, XMLStreamException;
}
