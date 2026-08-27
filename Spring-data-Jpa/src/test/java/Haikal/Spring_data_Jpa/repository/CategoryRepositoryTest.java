package Haikal.Spring_data_Jpa.repository;

import Haikal.Spring_data_Jpa.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void Insert() {
        Category category = new Category();
        category.setName("Gadget");

        categoryRepository.save(category);

        assertNotNull(category.getId());
    }

    @Test
    void Update() {
        Category category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);

        category.setName("Gadget Murah");
        categoryRepository.save(category);

        category = categoryRepository.findById(1L).orElse(null);
        assertNotNull(category);
        assertEquals("Gadget Murah", category.getName());
    }
}