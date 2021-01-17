package pl.lukaszkutylowski.barapp.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.Instant;

@Entity
@Table(name = "invoices")
public class Invoice {
    private static final long serialVersionUID = 345L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoice_id;
    private String nip;
    private Instant date;
    private Double orderPrice;

    public Invoice() {}

    public Invoice(String nip, Instant date, Double orderPrice) {
        this.nip = nip;
        this.date = date;
        this.orderPrice = orderPrice;
    }

    public Long getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
