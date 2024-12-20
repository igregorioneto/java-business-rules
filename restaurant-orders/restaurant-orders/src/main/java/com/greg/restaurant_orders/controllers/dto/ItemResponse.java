package com.greg.restaurant_orders.controllers.dto;

import java.util.List;

public record ItemResponse(
        List<ItemResponseDto> itemResponseDtos,
        int page,
        int pageSize,
        int totalPages,
        Long totalElements
) {
}
