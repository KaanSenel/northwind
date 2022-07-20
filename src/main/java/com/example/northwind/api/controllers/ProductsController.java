package com.example.northwind.api.controllers;

import com.example.northwind.business.abstracts.ProductService;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String name){
        return this.productService.getByProductName(name);
    }

    @GetMapping("/getByProductNameAndCategory")
    DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategory")
    DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName,@RequestParam int categoryId){
        return this.productService.getByProductNameOrCategory(productName,categoryId);
    }

    @GetMapping("/getByCategoryIn")
    DataResult<List<Product>> getByCategoryIn(@RequestParam List<Integer> categoryId){
        return this.productService.getByCategoryIn(categoryId);
    }

    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>> getByProductNameContains(@RequestParam String name){
        return this.productService.getByProductNameContains(name);
    }

    @GetMapping("/getByProductNameStartsWith")
    DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String name){
        return this.productService.getByProductNameStartsWith(name);
    }

    @GetMapping("/getByNameAndCategory")
    DataResult<List<Product>> getByNameAndCategory(@RequestParam String name,@RequestParam int id){
        return this.productService.getByNameAndCategory(name,id);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(@RequestParam int pageNo,@RequestParam int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSortedAsc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @GetMapping("/getAllSortedDesc")
    public DataResult<List<Product>> getAllSortedDesc(){
        //Pageable ve Sort sınıflarını bi oku az
        return this.productService.getAllSortedReverse();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

}