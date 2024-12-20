package com.greg.restaurant_orders.services;

import com.greg.restaurant_orders.controllers.dto.CreateItemDto;
import com.greg.restaurant_orders.controllers.dto.ItemCategoryItemDto;
import com.greg.restaurant_orders.controllers.dto.ItemResponseDto;
import com.greg.restaurant_orders.entities.Item;
import com.greg.restaurant_orders.entities.ItemCategory;
import com.greg.restaurant_orders.repositories.ItemCategoryRepository;
import com.greg.restaurant_orders.repositories.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

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

    public Page<ItemResponseDto> findAll(int page, int pageSize) {
        return itemRepository.findAll(PageRequest.of(page, pageSize, Sort.Direction.ASC, "nameItem"))
                .map(item -> new ItemResponseDto(
                        item.getNameItem(),
                        item.getPrice(),
                        item.getItemCategories().stream()
                                .map(category -> new ItemCategoryItemDto(category.getNameCategory()))
                                .collect(Collectors.toList())
                ));
    }
}
