package rancheros.com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Daniel on 11/06/2016.
 */
@Entity
@Table(name = "person")
public class Person {

    @Id
    private String id;
    private String name;
    private String firtsname;
    private String lastname;
    private String dni;
    private String phone;

    public Person() {
    }

    public Person(String id, String name, String firtsname, String lastname, String dni, String phone) {
        this.id = id;
        this.name = name;
        this.firtsname = firtsname;
        this.lastname = lastname;
        this.dni = dni;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirtsname() {
        return firtsname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }
}
