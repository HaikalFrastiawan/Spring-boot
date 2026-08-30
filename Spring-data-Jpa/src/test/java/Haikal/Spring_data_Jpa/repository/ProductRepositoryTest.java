package Haikal.Spring_data_Jpa.repository;

import Haikal.Spring_data_Jpa.entity.Category;
import Haikal.Spring_data_Jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        {
            Product product = new Product();
            product.setName("Apple iphone 14");
            product.setPrice(25_000_000L);
            product.setCategory(category);
            productRepository.save(product);
        }
        {
            Product product = new Product();
            product.setName("Apple iphone 13");
            product.setPrice(18_000_000L);
            product.setCategory(category);
            productRepository.save(product);
        }

    }

    @Test
    void findByCategoryName() {
        List<Product> product = productRepository.findAllByCategory_Name("Gadget Murah");
        assertEquals(2, product.size());
        assertEquals("Apple iphone 14", product.get(0).getName());
        assertEquals("Apple iphone 13", product.get(1).getName());
    }
    @Test
    void Sort() {

        Sort sort = Sort.by(Sort.Order.desc("id"));
        List<Product> product = productRepository.findAllByCategory_Name("Gadget Murah", sort);
        assertEquals(2, product.size());
        assertEquals("Apple iphone 13", product.get(0).getName());
        assertEquals("Apple iphone 14", product.get(1).getName());
    }

}