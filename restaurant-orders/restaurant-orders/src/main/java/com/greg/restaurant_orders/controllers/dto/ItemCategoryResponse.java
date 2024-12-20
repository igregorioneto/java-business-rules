package com.greg.restaurant_orders.controllers.dto;

import java.util.List;

public record ItemCategoryResponse(
        List<ItemCategoryItemDto> itemCategoryItemDtos,
        int page,
        int pageSize,
        int totalPages,
        long totalElements
) {
}
