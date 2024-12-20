package com.greg.restaurant_orders.controllers;

import com.greg.restaurant_orders.controllers.dto.CreateItemDto;
import com.greg.restaurant_orders.controllers.dto.ItemResponse;
import com.greg.restaurant_orders.services.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<ItemResponse> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        var items = itemService.findAll(page, pageSize);
        return ResponseEntity.ok(
                new ItemResponse(
                        items.getContent(),
                        page,
                        pageSize,
                        items.getTotalPages(),
                        items.getTotalElements()
                )
        );
    }
}
