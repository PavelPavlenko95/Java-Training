package by.pavelpavlenko.xml.entity;

public class Lecture {

    private String name;
    private String id;
    private String lectureType;
    private String link;
    private float length;
    private boolean tests;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLectureType() {
        return lectureType;
    }

    public void setLectureType(String lectureType) {
        this.lectureType = lectureType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public boolean isTests() {
        return tests;
    }

    public void setTests(boolean tests) {
        this.tests = tests;
    }

    public boolean getTests() {
        return tests;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
