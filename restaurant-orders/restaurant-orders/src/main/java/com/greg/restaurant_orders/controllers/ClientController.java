package com.greg.restaurant_orders.controllers;

import com.greg.restaurant_orders.controllers.dto.ClientResponse;
import com.greg.restaurant_orders.controllers.dto.CreateClientDTO;
import com.greg.restaurant_orders.entities.Client;
import com.greg.restaurant_orders.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateClientDTO dto) {
        clientService.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClientResponse> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        var clients  = clientService.findAll(page, pageSize);
        return ResponseEntity.ok(
                new ClientResponse(
                        clients.getContent(),
                        page,
                        pageSize,
                        clients.getTotalPages(),
                        clients.getTotalElements()
                )
        );
    }

}
