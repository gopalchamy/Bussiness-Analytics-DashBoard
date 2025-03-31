package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
@Service
public class CategoryService 
{
    @Autowired
    private CategoryRepository cs;
    public Category insertcategory(Category c)
    {
        return cs.save(c);
    }
    public List<Category>getcategory()
    {
        return cs.findAll();
    }
    public Optional<Category>getcategorybyid(int id)
    {
        return cs.findById(id);
    }
    public Category updateCategory(int id,Category cu)
    {
        cu.setId(id);
        return cs.save(cu);

    }
    public String deleteCategorybyid(int id)
    {
        cs.deleteById(id);
        return "Category is deleted";
    }



    
}
