package com.greg.restaurant_orders.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_item_category")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name_category", unique = true)
    private String nameCategory;

    @ManyToMany(mappedBy = "itemCategories")
    private Set<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
