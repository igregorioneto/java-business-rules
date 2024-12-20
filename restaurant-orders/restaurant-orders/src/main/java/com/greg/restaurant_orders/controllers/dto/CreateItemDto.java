package com.greg.restaurant_orders.controllers.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateItemDto(
        @NotNull String nameItem,
        @NotNull BigDecimal price,
        @NotNull Long itemCategoryId
        ) {
}
