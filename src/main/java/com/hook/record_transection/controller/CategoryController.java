package com.hook.record_transection.controller;

import java.util.List;
import java.util.Optional;

import com.hook.record_transection.model.Category;
import com.hook.record_transection.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @PostMapping("")
    public Category saveCat(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }
    @GetMapping("{/id}")
    public Optional<Category> findById(@PathVariable int id){
        return categoryService.findById(id);
    }
    @DeleteMapping("{/id}")
    public Integer deleteCat(@PathVariable Integer id){
       return id;
    }
    @PutMapping("/{id}")
    public Category updateCat(@RequestBody Category category,@PathVariable int id) {
        return categoryService.updateCategory(category,id);
    }
}