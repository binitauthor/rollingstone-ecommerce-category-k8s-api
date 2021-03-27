package com.rollingstone.spring.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.CategoryEvent;
import com.rollingstone.spring.model.Category;
import com.rollingstone.spring.service.CategoryService;

@RestController
public class CategoryController extends AbstractController {


    private CategoryService  CategoryService;

    public CategoryController(CategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }

    /*---Add new Category---*/
    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody Category Category) {
        Category savedCategory = CategoryService.save(Category);
        CategoryEvent CategoryCreatedEvent = new CategoryEvent("One Category is created", savedCategory);
        eventPublisher.publishEvent(CategoryCreatedEvent);
        return ResponseEntity.ok().body("New Category has been saved with ID:" + savedCategory.getId());
    }

    /*---Get a Category by id---*/
    @GetMapping("/category/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable("id") long id) {
        Optional<Category> returnedCategory = CategoryService.get(id);
        Category Category  = returnedCategory.get();

        CategoryEvent CategoryCreatedEvent = new CategoryEvent("One Category is retrieved", Category);
        eventPublisher.publishEvent(CategoryCreatedEvent);
        return Category;
    }



    /*---get all Category---*/
    @GetMapping("/category")
    public @ResponseBody Page<Category> getCategoriesByPage(
            @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
            @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
        Page<Category> pagedCategorys = CategoryService.getCategorysByPage(pageNumber, pageSize);
        return pagedCategorys;
    }

    /*---Update a Category by id---*/
    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") long id, @RequestBody Category Category) {
        checkResourceFound(this.CategoryService.get(id));
        CategoryService.update(id, Category);
        return ResponseEntity.ok().body("Category has been updated successfully.");
    }

    /*---Delete a Category by id---*/
    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id) {
        checkResourceFound(this.CategoryService.get(id));
        CategoryService.delete(id);
        return ResponseEntity.ok().body("Category has been deleted successfully.");
    }
}