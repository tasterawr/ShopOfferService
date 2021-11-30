package org.loktevik.netcracker.repository;

import org.loktevik.netcracker.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getById(Long id);

    List<Category> findAll();

    Category save(Category category);

    void deleteById(Long id);
}
