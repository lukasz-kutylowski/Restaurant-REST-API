package pl.lukaszkutylowski.barapp.payload;

public class PayloadOrder {
    private String[] ids;
    private String name;
    private String surname;
    private String nip;

    PayloadOrder() {}

    public PayloadOrder(String[] ids, String name, String surname, String nip) {
        this.ids = ids;
        this.name = name;
        this.surname = surname;
        this.nip = nip;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
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
