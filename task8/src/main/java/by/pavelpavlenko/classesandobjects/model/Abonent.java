package by.pavelpavlenko.classesandobjects.model;

import java.util.List;

public class Abonent extends Model{

    private String name;
    private String lastName;
    private String patronymic;
    private String address;

    private List<Phone> phones;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Abonent(int id, String name, String lastName, String patronymic, String address) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
    }

    public Abonent(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abonent abonent = (Abonent) o;

        if (name != null ? !name.equals(abonent.name) : abonent.name != null) return false;
        if (lastName != null ? !lastName.equals(abonent.lastName) : abonent.lastName != null) return false;
        if (patronymic != null ? !patronymic.equals(abonent.patronymic) : abonent.patronymic != null) return false;
        return address != null ? address.equals(abonent.address) : abonent.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
