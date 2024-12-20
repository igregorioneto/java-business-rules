package com.greg.restaurant_orders.controllers.dto;

import com.greg.restaurant_orders.entities.ItemCategory;

import java.math.BigDecimal;
import java.util.List;

public record ItemResponseDto(
        String nameItem,
        BigDecimal price,
        List<ItemCategoryItemDto> itemCategory
) {
}
