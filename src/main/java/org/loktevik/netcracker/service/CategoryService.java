package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Category;

import java.util.List;

public interface CategoryService {
    Category getById(Long id);

    List<Category> getAll();

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteById(Long id);
}
