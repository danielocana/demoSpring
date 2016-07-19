package rancheros.com.domain.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {

    @Id
    private String id;
    @Size(min=4, max=25)
    private String name;
    private String dni;
    private String phone;

    public Person() {
    }

    public Person(String id, String name, String dni, String phone) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
