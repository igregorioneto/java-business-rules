package com.greg.restaurant_orders.services;

import com.greg.restaurant_orders.controllers.dto.CreateItemDto;
import com.greg.restaurant_orders.entities.Item;
import com.greg.restaurant_orders.entities.ItemCategory;
import com.greg.restaurant_orders.repositories.ItemCategoryRepository;
import com.greg.restaurant_orders.repositories.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ItemService {

    private final ItemRepository itemRepository;;
    private final ItemCategoryRepository itemCategoryRepository;

    public ItemService(
            ItemRepository itemRepository,
            ItemCategoryRepository itemCategoryRepository
    ) {
        this.itemRepository = itemRepository;
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public void create(@Valid CreateItemDto dto) {
        var itemCategory = itemCategoryRepository.findById(dto.itemCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        var item = new Item();
        item.setNameItem(dto.nameItem());
        item.setPrice(dto.price());
        item.setItemCategories(Collections.singleton(itemCategory));

        itemRepository.save(item);
    }
}
