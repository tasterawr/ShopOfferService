package org.loktevik.netcracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;
import org.loktevik.netcracker.domain.Category;
import org.loktevik.netcracker.repository.CategoryRepository;
import org.loktevik.netcracker.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final Logger log = Logger.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepo;

    @Override
    public Category getById(Long id) {
        log.info(new FormattedMessage("Getting category with id: {}.", id));
        return categoryRepo.getById(id);
    }

    @Override
    public List<Category> getAll() {
        log.info("Getting all categories.");
        return categoryRepo.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        log.info(new FormattedMessage("Saving category \"{}\".", category.getName()));
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        log.info(new FormattedMessage("Updating category with id: {}.", category.getId()));
        return saveCategory(category);
    }

    @Override
    public void deleteById(Long id) {
        log.info(new FormattedMessage("Deleting category with id: {}.", id));
        categoryRepo.deleteById(id);
    }
}
