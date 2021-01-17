package pl.lukaszkutylowski.barapp.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "clients")
public class Client {
    private static final long serialVersionUID = 234L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;
    private String name;
    private String surname;
    private String nip;

    public Client() {}

    public Client(String name, String surname, String nip) {
        this.name = name;
        this.surname = surname;
        this.nip = nip;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
