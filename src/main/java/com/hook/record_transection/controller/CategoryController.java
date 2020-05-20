package com.hook.record_transection.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.hook.record_transection.GlobalFunction;
import com.hook.record_transection.model.Category;
import com.hook.record_transection.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    // @GetMapping("/{id}")
    // public Optional<Category> findById(@PathVariable int id){
    //     return categoryService.findById(id);
    // }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> findById(@PathVariable Integer id){
        return new ResponseEntity<>(GlobalFunction.getResponeBody("Data is Ok for successfuclly", categoryService.findById(id)),HttpStatus.ACCEPTED);
        
    }
    // @DeleteMapping("/{id}")
    // public void  deleteCat(@PathVariable Integer id){
    //     categoryService.deleteCategory(id);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> deleteCategory(@PathVariable Integer id){
        Category category=categoryService.deleteCategory(id);
        if(category==null){
            return new ResponseEntity<>(GlobalFunction.getResponeBody("delete fail", category),HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(GlobalFunction.getResponeBody("delete successfully", category),HttpStatus.ACCEPTED);
    }
    // @PutMapping("/{id}")
    // public Category updateCat(@RequestBody Category category,@PathVariable int id) {
    //     return categoryService.updateCategory(category,id);
    // }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> updateCate(@RequestBody Category category,@PathVariable Integer id){
            return new ResponseEntity<>(GlobalFunction.getResponeBody("update successFully", categoryService.updateCategory(category, id)),HttpStatus.ACCEPTED);
    }
}