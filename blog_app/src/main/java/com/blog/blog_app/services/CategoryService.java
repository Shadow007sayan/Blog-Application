package com.blog.blog_app.services;

import com.blog.blog_app.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    //create
    //By default in interface all are public so no need to add public
     CategoryDto createCategory(CategoryDto categoryDto);

    //Update
     CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //Delete
     void deleteCategory(Integer categoryId);
    //Get
     CategoryDto getCategory(Integer categoryId);
    //GetAll
     List<CategoryDto> getCategories();
}
