package com.greg.restaurant_orders.controllers;

import com.greg.restaurant_orders.controllers.dto.CreateItemDto;
import com.greg.restaurant_orders.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/menu")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateItemDto dto) {
        itemService.create(dto);
        return ResponseEntity.ok().build();
    }
}
