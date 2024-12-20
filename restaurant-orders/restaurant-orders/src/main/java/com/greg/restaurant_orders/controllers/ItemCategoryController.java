package com.greg.restaurant_orders.controllers;

import com.greg.restaurant_orders.controllers.dto.CreateItemCategoryDto;
import com.greg.restaurant_orders.controllers.dto.ItemCategoryResponse;
import com.greg.restaurant_orders.services.ItemCategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/items-categories")
public class ItemCategoryController {

    private final ItemCategoryService itemCategoryService;

    public ItemCategoryController(ItemCategoryService itemCategoryService) {
        this.itemCategoryService = itemCategoryService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateItemCategoryDto dto) {
        itemCategoryService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ItemCategoryResponse> findAll(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        var itemsCategory = itemCategoryService.findAll(page, pageSize);
        return ResponseEntity.ok(
                new ItemCategoryResponse(
                        itemsCategory.getContent(),
                        page,
                        pageSize,
                        itemsCategory.getTotalPages(),
                        itemsCategory.getTotalElements()
                )
        );
    }
}
