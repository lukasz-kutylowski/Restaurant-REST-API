package pl.lukaszkutylowski.barapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszkutylowski.barapp.dao.InvoiceRepository;
import pl.lukaszkutylowski.barapp.dao.OrderRepository;
import pl.lukaszkutylowski.barapp.model.Invoice;
import pl.lukaszkutylowski.barapp.model.Order;
import pl.lukaszkutylowski.barapp.model.Product;

import java.time.Instant;
import java.util.List;

@Service
public class InvoiceService {

    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(
            OrderRepository orderRepository,
            InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice createInvoiceByOrderId(Long id) {
        Invoice invoice = new Invoice();

        Order orderById = orderRepository.findById(id).get();
        List<Product> products = orderById.getProducts();
        Double orderPrice = calculateOrderPrice(products);

        invoice = setInvoiceDetails(invoice, orderPrice, orderById);
        Invoice savedInvoice = invoiceRepository.save(invoice);

        orderById.setInvoice(savedInvoice);
        orderRepository.save(orderById);

        return savedInvoice;
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).get();
    }

    private Double calculateOrderPrice(List<Product> products) {
        Double orderPrice = 0.0;
        for (Product p : products) {
            orderPrice += p.getPrice();
        }
        return orderPrice;
    }

    private Invoice setInvoiceDetails(Invoice invoice, Double orderPrice, Order orderById) {
        invoice.setOrderPrice(orderPrice);
        invoice.setNip(orderById.getClient().getNip());
        invoice.setDate(Instant.now());
        return invoice;
    }
}
