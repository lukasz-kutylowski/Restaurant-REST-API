package pl.lukaszkutylowski.barapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszkutylowski.barapp.model.Invoice;
import pl.lukaszkutylowski.barapp.service.InvoiceService;

@RestController
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/invoice/{order_id}")
    public ResponseEntity<Invoice> createInvoiceByOrderId(@PathVariable Long order_id) {
        Invoice invoiceByOrderId = invoiceService.createInvoiceByOrderId(order_id);
        return ResponseEntity.ok().body(invoiceByOrderId);
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Invoice invoiceById = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoiceById);
    }
}
