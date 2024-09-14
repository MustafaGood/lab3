package org.service;

import org.entities.Product;
import org.entities.Category;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class WarehouseTests {
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = new Warehouse();
        Product initialProduct = new Product("1", "Laptop", Category.ELECTRONICS, 10, LocalDate.now(), LocalDate.now());
        warehouse.addProduct(initialProduct);
    }

    @Test
    void addProduct_NullName_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                warehouse.addProduct(new Product("2", null, Category.GROCERY, 5, LocalDate.now(), LocalDate.now())));
        assertTrue(exception.getMessage().contains("Product name cannot be empty"));
    }

    @Test
    void modifyProduct_ChangeName_UpdatesSuccessfully() {
        warehouse.modifyProduct("1", "Gaming Laptop", Category.ELECTRONICS, 10);
        Product updatedProduct = warehouse.getProductById("1");
        assertEquals("Gaming Laptop", updatedProduct.name());
}
}
