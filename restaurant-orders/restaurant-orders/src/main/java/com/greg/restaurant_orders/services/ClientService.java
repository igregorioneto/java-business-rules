package com.greg.restaurant_orders.services;

import com.greg.restaurant_orders.controllers.dto.ClientItemDto;
import com.greg.restaurant_orders.controllers.dto.CreateClientDTO;
import com.greg.restaurant_orders.entities.Client;
import com.greg.restaurant_orders.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(CreateClientDTO dto) {
        if (dto.name().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        var client = new Client();
        client.setName(dto.name());
        clientRepository.save(client);
    }

    public Page<ClientItemDto> findAll(int page, int pageSize) {
        return clientRepository.findAll(PageRequest.of(page, pageSize, Sort.Direction.ASC, "name"))
                .map(client -> new ClientItemDto(client.getName()));
    }
}
