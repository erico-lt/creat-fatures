package com.create_fatures.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.create_fatures.entites.Clients;
import com.create_fatures.entites.Item;
import com.create_fatures.repositories.ClientsRepository;
import com.create_fatures.repositories.ItemRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public void run(String... args) throws Exception {
        Clients c1 = new Clients(null, "Érico", "243446", "erico.blp@gmail.com", "Rua Maria Ribeiro", "5667432");

        clientsRepository.save(c1);

        Item item1 = new Item(null, "Tv Plasma", 1800.00);

        itemRepository.save(item1);    
        
    }    
    
}
