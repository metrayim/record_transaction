package com.hook.record_transection.service;

import java.util.List;
import java.util.Optional;

import com.hook.record_transection.model.Category;
import com.hook.record_transection.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> findAll(){
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findById(int id){
        return this.categoryRepository.findById(id);
    }

    public Category updateCategory(Category category, int id){
        Category _category= this.categoryRepository.getOne(id);
        _category.setImage(category.getImage());
        _category.setName(category.getName());
        _category.setPrice(category.getPrice());
        _category.setCreateDate(category.getCreateDate());
        return this.categoryRepository.save(_category);

    }
    public void deleteCategory(Integer id){
         this.categoryRepository.deleteById(id);
    }

}