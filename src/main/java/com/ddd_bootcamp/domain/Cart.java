package com.ddd_bootcamp.domain;

import com.ddd_bootcamp.domain.events.DomainEvent;
import com.ddd_bootcamp.domain.events.ItemAddedToCartEvent;
import com.ddd_bootcamp.domain.events.ItemRemovedFromCartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {

    private List<DomainEvent> events = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        ItemAddedToCartEvent itemAddedEvent =
                new ItemAddedToCartEvent(item.getProductName(),
                        item.getQuantity());

        apply(itemAddedEvent);
    }

    public List<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
        ItemRemovedFromCartEvent itemRemovedFromCartEvent =
                new ItemRemovedFromCartEvent(item.getProductName());

        apply(itemRemovedFromCartEvent);
    }

    private void apply(ItemAddedToCartEvent event) {
        events.add(event);
        this.items.add(new Item(new Product(event.getProductName()), event.getQuantity()));
    }

    private void apply(ItemRemovedFromCartEvent event) {
        events.add(event);
        this.items.
                remove(this.items.stream().filter(item -> item.getProductName()
                        .equals(event.getProductName())).findFirst().get());
    }

    public Set<String> removedProductNames() {
        return events.stream()
                .filter(event -> event instanceof ItemRemovedFromCartEvent)
                .map(event -> ((ItemRemovedFromCartEvent) event).getProductName())
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "events=" + events +
                ", items=" + items +
                '}';
    }
}