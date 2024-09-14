package org.entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ProductTests {

    @Test
    void createProduct_CheckProperties_ReturnsCorrectly() {
        Product product = new Product("1", "Laptop", Category.ELECTRONICS, 10, LocalDate.now(), LocalDate.now());
        assertEquals("Laptop", product.name());
        assertEquals(Category.ELECTRONICS, product.category());
        assertEquals(10, product.rating());
    }
}
