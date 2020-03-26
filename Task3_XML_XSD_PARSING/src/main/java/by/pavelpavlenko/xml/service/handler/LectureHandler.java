package by.pavelpavlenko.xml.service.handler;

import by.pavelpavlenko.xml.entity.Category;
import by.pavelpavlenko.xml.entity.Lecture;
import by.pavelpavlenko.xml.entity.LectureType;
import by.pavelpavlenko.xml.entity.TrainingPortal;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LectureHandler extends DefaultHandler {

    private List<Lecture> lectureList;
    private Category category = null;
    private Lecture lecture = null;
    private LectureType lectureType = null;
    private String content = null;

    public LectureHandler(final ArrayList<Lecture> lectures){
        this.lectureList = lectures;
    }

    private static final String ID = "id";

    private TrainingPortal trainingPortal;

    @Override
    public void characters(char[] ch, int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }

    @Override
    public void startDocument() {
        trainingPortal = new TrainingPortal();
    }

    @Override
    public void startElement(String uri, String localMane, String qName, Attributes attributes) {
        switch (qName) {
            case "lecture":
                lecture = new Lecture();
                lecture.setId(attributes.getValue(ID));
                break;
            case "category":
                category = new Category();
                category.setId(attributes.getValue(ID));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "lecture":
                lectureList.add(lecture);
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
    }
}