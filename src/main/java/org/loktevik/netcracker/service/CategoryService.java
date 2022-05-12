package org.loktevik.netcracker.service;

import org.loktevik.netcracker.domain.Category;

import java.util.List;

/**
 * Service interface for Category model.
 */
public interface CategoryService {

    /**
     * Finds category with specified id.
     * @param id id of category.
     * @return instance of category with specified id.
     */
    Category getById(Long id);

    /**
     * Finds all categories in the database.
     * @return List of all categories from database.
     */
    List<Category> getAll();

    /**
     * Saves new or updates existing category in database.
     * @param category instance of new or existing
     * @return created or updated category.
     */
    Category saveCategory(Category category);


    /**
     * Updates category.
     * @param category instance of updating category.
     * @return returns updated category.
     */
    Category updateCategory(Category category);

    /**
     * Deletes category with specified id from database.
     * @param id id of category.
     */
    void deleteById(Long id);
}
