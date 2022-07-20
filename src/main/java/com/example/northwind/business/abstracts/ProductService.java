package com.example.northwind.business.abstracts;

import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;
import com.example.northwind.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAll(int pageNo,int pageSize);

    DataResult<List<Product>> getAllSorted();

    DataResult<List<Product>> getAllSortedReverse();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categoryId);

    DataResult<List<Product>> getByProductNameContains(String name);

    DataResult<List<Product>> getByProductNameStartsWith(String name);

    DataResult<List<Product>> getByNameAndCategory(String name,int id);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
