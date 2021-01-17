package pl.lukaszkutylowski.barapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszkutylowski.barapp.dao.ClientRepository;
import pl.lukaszkutylowski.barapp.dao.OrderRepository;
import pl.lukaszkutylowski.barapp.dao.ProductRepository;
import pl.lukaszkutylowski.barapp.model.Client;
import pl.lukaszkutylowski.barapp.model.Order;
import pl.lukaszkutylowski.barapp.payload.PayloadOrder;

import java.time.Instant;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            ClientRepository clientRepository,
            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public Order createOrder(PayloadOrder payloadOrder) {
        Order order = new Order();

        String[] ids = payloadOrder.getIds();
        Client client = createClientFromPayloadData(payloadOrder);
        order = addProductsFromPayloadToOrder(ids);
        order.setDate(Instant.now());
        order = setClientInOrder(order, client);

        return orderRepository.save(order);
    }

    private Client createClientFromPayloadData(PayloadOrder payloadOrder) {
        return new Client(
                payloadOrder.getName(),
                payloadOrder.getSurname(),
                payloadOrder.getNip()
        );
    }

    private Order addProductsFromPayloadToOrder(String[] ids) {
        Order temporaryOrder = new Order();
        for (String id : ids) {
            temporaryOrder.getProducts().add(productRepository.findById(Long.parseLong(id)).get());
        }
        return temporaryOrder;
    }

    private Order setClientInOrder(Order order, Client client) {
        Client clientByNip = clientRepository.getClientByNip(client.getNip());
        if (clientByNip != null) {
            order.setClient(clientByNip);
        } else {
            Client savedClient = clientRepository.save(client);
            order.setClient(savedClient);
        }
        return order;
    }
}
