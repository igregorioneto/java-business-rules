package com.greg.restaurant_orders.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name_item", unique = true)
    private String nameItem;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "item_item_categories",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "item_category_id")
    )
    private Set<ItemCategory> itemCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(Set<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
    }
}
