package com.greg.restaurant_orders.controllers.dto;

import jakarta.validation.constraints.NotNull;

public record CreateItemCategoryDto(@NotNull String nameCategory) {
}
