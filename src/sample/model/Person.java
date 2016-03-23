package sample.model;

import java.util.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 */
public class Person {

    private final StringProperty name;
    private final StringProperty tel;
    private final StringProperty hobby;
    private final StringProperty city;
    private final ObjectProperty<Date> birthday;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param name
     * @param tel
     */
    public Person(String name, String tel) {
        this.name = new SimpleStringProperty(name);
        this.tel = new SimpleStringProperty(tel);
        this.hobby = new SimpleStringProperty("сно╥");
        this.city = new SimpleStringProperty("до╬╘");
        this.birthday = new SimpleObjectProperty<>(new Date());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getTel() {
        return tel.get();
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    public StringProperty telProperty() {
        return tel;
    }

    public String getHobby() {
        return hobby.get();
    }

    public void setHobby(String postalCode) {
        this.hobby.set(postalCode);
    }

    public StringProperty postalCodeProperty() {
        return hobby;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public Date getBirthday() {
        return birthday.get();
    }

    public void setBirthday(Date birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<Date> birthdayProperty() {
        return birthday;
    }
}