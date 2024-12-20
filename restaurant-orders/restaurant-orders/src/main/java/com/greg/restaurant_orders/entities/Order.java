package com.greg.restaurant_orders.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itemsOrder;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_order")
    private StatusOrderEnum statusOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItemsOrder() {
        return itemsOrder;
    }

    public void setItemsOrder(List<Item> itemsOrder) {
        this.itemsOrder = itemsOrder;
    }

    public StatusOrderEnum getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrderEnum statusOrder) {
        this.statusOrder = statusOrder;
    }
}
