package com.create_fatures.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.create_fatures.entites.Clients;
import com.create_fatures.entites.Item;
import com.create_fatures.entites.PurchaseItem;
import com.create_fatures.entites.Order;
import com.create_fatures.repositories.ClientsRepository;
import com.create_fatures.repositories.ItemRepository;
import com.create_fatures.repositories.OrderRepository;
import com.create_fatures.repositories.PurchaseItemRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Clients c1 = new Clients(null, "Érico", "243446", "erico.blp@gmail.com", "Rua Maria Ribeiro", "5667432");

        clientsRepository.save(c1);

        Item i1 = new Item(null, "Tv Plasma", 50.00);
        Item i2 = new Item(null, "Mouse", 20.00);

        itemRepository.saveAll(Arrays.asList(i1,i2));

        Order order = new Order(null, Instant.now(), c1);

        orderRepository.save(order);

        PurchaseItem item1 = new PurchaseItem(order, i1, 2, i1.getPrice());
        PurchaseItem item2 = new PurchaseItem(order, i2, 2, i2.getPrice());

        purchaseItemRepository.saveAll(Arrays.asList(item1, item2));

    }

}
