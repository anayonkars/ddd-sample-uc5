package com.ddd_bootcamp;

import com.ddd_bootcamp.domain.Cart;
import com.ddd_bootcamp.domain.Item;
import com.ddd_bootcamp.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkflowTest {

    @Test
    public void testForUniqueCarts() {
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Item item1 = new Item(new Product("Sony Wireless headphone"), 1);
                Item item2 = new Item(new Product("Sony Wireless headphone"), 1);
                cart1.add(item1);
        cart2.add(item2);
        Assertions.assertFalse(cart1.equals(cart2));
    }
}
