package com.greg.restaurant_orders.services;

import com.greg.restaurant_orders.controllers.dto.CreateItemCategoryDto;
import com.greg.restaurant_orders.controllers.dto.ItemCategoryItemDto;
import com.greg.restaurant_orders.entities.ItemCategory;
import com.greg.restaurant_orders.repositories.ItemCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryService {

    private final ItemCategoryRepository itemCategoryRepository;

    public ItemCategoryService(ItemCategoryRepository itemCategoryRepository) {
        this.itemCategoryRepository = itemCategoryRepository;
    }

    public void create(@Valid CreateItemCategoryDto dto) {
        var entity = new ItemCategory();
        entity.setNameCategory(dto.nameCategory());
        itemCategoryRepository.save(entity);
    }

    public Page<ItemCategoryItemDto> findAll(int page, int pageSize) {
        return itemCategoryRepository.findAll(PageRequest.of(page, pageSize, Sort.Direction.ASC, "nameCategory"))
                .map(item -> new ItemCategoryItemDto(item.getNameCategory()));
    }
}
