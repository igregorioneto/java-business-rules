package com.greg.restaurant_orders.controllers.dto;

import java.util.List;

public record ClientResponse(
        List<ClientItemDto> clients,
        int page,
        int pageSize,
        int totalPages,
        long totalElements
) {
}
