package com.example.backend.controller;

import com.example.backend.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final categoryService categoryService;
    @GetMapping
    public Page<Category> getAllCategories(
            @RequestParam(required = false) int pageSize
            @RequestParam int pageNumber
    ){
      return categoryService.getAllCategories( pageNumber,pageSize)
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequest categoryRequest){
        return categoryService.createCategory(categoryRequest);    }

}
