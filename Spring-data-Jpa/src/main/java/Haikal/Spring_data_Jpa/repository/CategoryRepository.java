package Haikal.Spring_data_Jpa.repository;

import Haikal.Spring_data_Jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //where name = ?
    Optional <Category> findFirstByNameEquals(String name);


    List<Category> findAllByNameLike(String name);
}
