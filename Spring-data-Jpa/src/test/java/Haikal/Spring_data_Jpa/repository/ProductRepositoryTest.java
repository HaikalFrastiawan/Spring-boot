package Haikal.Spring_data_Jpa.repository;

import Haikal.Spring_data_Jpa.entity.Category;
import Haikal.Spring_data_Jpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Test
    void pageabele() {

        //page 0
        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")));
        Page<Product> products = productRepository.findAllByCategory_Name("Gadget Murah", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(0, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
        assertEquals("Apple iphone 13",products.getContent().get(0).getName());

        //page 1
        pageable = PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")));
        products = productRepository.findAllByCategory_Name("Gadget Murah", pageable);
        assertEquals(1, products.getContent().size());
        assertEquals(1, products.getNumber());
        assertEquals(2, products.getTotalElements());
        assertEquals(2, products.getTotalPages());
        assertEquals("Apple iphone 14",products.getContent().get(0).getName());
    }

    @Test
    void count() {
        long count = productRepository.count();
        assertEquals(2L, count);

        count = productRepository.countByCategory_Name("Gadget Murah");
        assertEquals(2L, count);

        count = productRepository.countByCategory_Name("Gak ada");
        assertEquals(0L, count);
    }

    @Test
    void exists() {
        boolean exists = productRepository.existsByName("Apple Iphone 14");
        assertTrue(exists);

         exists = productRepository.existsByName("Apple Iphone 14 salah");
        assertFalse(exists);

    }
}