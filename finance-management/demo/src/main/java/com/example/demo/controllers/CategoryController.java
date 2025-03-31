package com.example.demo.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Category;
import com.example.demo.entities.Transaction;
import com.example.demo.services.CategoryService;
import com.example.demo.services.TransactionService;
@RestController
public class CategoryController {
    @Autowired
    private CategoryService c;
    private TransactionService cs;
    @PostMapping("/category/add")
    public Category insertCategory(@RequestBody Category cs)
    {
        return c.insertcategory(cs);
    }
    @GetMapping("/category/get")
    public List<Category> getCategory()
    {
        return c.getcategory();
    }
    @GetMapping("/category/get/{id}")
        public ResponseEntity<Category>getCategorybyid(@PathVariable int id)
    {
        Optional<Category>cs=c.getcategorybyid(id);
        if(cs.isPresent())
        {
            return ResponseEntity.ok(cs.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/category/update/{id}")
    public Category updatebudget(@PathVariable int id,@RequestBody Category cs)
    {
        return c.updateCategory(id,cs);
    }
    @DeleteMapping("/category/delete/{id}")
    public String deletebudget(@PathVariable int id)
    {
        return c.deleteCategorybyid(id);
    }
    @GetMapping("/transaction/{catid}")
    public List<Transaction>getTransactionByCatId(@PathVariable int id)
    {
        return cs.getTransactionbycatid(id);
    }
    
    
}
